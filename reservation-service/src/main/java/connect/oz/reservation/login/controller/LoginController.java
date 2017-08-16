package connect.oz.reservation.login.controller;

import connect.oz.reservation.login.dto.NaverLoginResponseDto;
import connect.oz.reservation.login.dto.NaverLoginUserDto;
import connect.oz.reservation.login.service.LoginService;
import connect.oz.reservation.util.NaverLoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private NaverLoginUtil naverLoginUtil;
    private RestTemplate restTemplate;
    private LoginService loginService;

    @Autowired
    public LoginController(  NaverLoginUtil naverLoginUtil, RestTemplate restTemplate,LoginService loginService) {
        this.loginService = loginService;
        this.naverLoginUtil = naverLoginUtil;
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public String naverLogin(HttpSession session) {
        String state = naverLoginUtil.generateState();
        session.setAttribute("state", state);

        return "redirect:" + naverLoginUtil.getOauthCallbackURL(state);
    }

    @GetMapping("/callback")
    public String callback(
            @RequestParam String state,
            @RequestParam String code,
            HttpServletRequest request){

        // 세션에 저장된 토큰을 받아옵니다.
        String storedState = (String) request.getSession().getAttribute("state");
        String redirectUrl = (String) request.getSession().getAttribute("redirectUrl");

        // 세션에 저장된 토큰과 인증을 요청해서 받은 토큰이 일치하는지 검증합니다.
        if (!state.equals(storedState)) {
            return "redirect:/";
        }

        ResponseEntity<Map<String, String>> entity = restTemplate.exchange(naverLoginUtil.getAccessTokenUrl(state, code),
                HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, String>>() {});

        logger.info("Entity : {} ", entity);

        if(entity.getStatusCodeValue() == 200) {
            Map<String, String> responseBody = entity.getBody();
            String accessToken = responseBody.get("access_token");

            if(accessToken != null && !accessToken.isEmpty()) {
                NaverLoginUserDto naverLoginUserDto = getUserProfile(accessToken);
                if(naverLoginUserDto != null){

                    loginService.login(naverLoginUserDto);
                    //디비에 저장
                    //세션에 저장
                    //redirect:/
                }
            }
        }

        return "redirect:/";
    }
    public NaverLoginUserDto getUserProfile(String accessToken){

        HttpHeaders header=new HttpHeaders();
        header.set("Authorization"," Bearer "+accessToken);
        HttpEntity<String> httpEntity=new HttpEntity<>(header);

        ResponseEntity<NaverLoginResponseDto> entity = restTemplate.exchange(naverLoginUtil.getProfileUrl(), HttpMethod.GET,
                httpEntity, new ParameterizedTypeReference<NaverLoginResponseDto>() {});
        logger.info("Entity : {} ", entity);

        if(200 == entity.getStatusCodeValue()){
            return entity.getBody().getUser();
        }
        return null;
    }
}
