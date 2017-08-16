package connect.oz.reservation.login.controller;

import connect.oz.reservation.util.NaverLoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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

    private NaverLoginUtil naverLoginUtil;
    private RestTemplate restTemplate;

    @Autowired
    public LoginController(NaverLoginUtil naverLoginUtil, RestTemplate restTemplate) {
        this.naverLoginUtil = naverLoginUtil;
        this.restTemplate = restTemplate;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public String naverLogin(HttpSession session) {
        String state = naverLoginUtil.generateState();
        session.setAttribute("state", state);

//        return "redirect:" + naverLoginUtil.reAuthenticateUrl(state);
        return "redirect:" + naverLoginUtil.getOauthCallbackURL(state);
    }

    @GetMapping("/callback")
    public String callback(
            @RequestParam String state,
            @RequestParam String code,
            HttpServletRequest request)
            throws UnsupportedEncodingException {

        // 세션에 저장된 토큰을 받아옵니다.
        String storedState = (String) request.getSession().getAttribute("state");
        String redirectUrl = (String) request.getSession().getAttribute("redirectUrl");

        // 세션에 저장된 토큰과 인증을 요청해서 받은 토큰이 일치하는지 검증합니다.
        if (!state.equals(storedState)) {
            return "redirect:/";
        }

        ResponseEntity<Map<String, String>> entity = restTemplate.exchange(naverLoginUtil.getAccessTokenUrl(state, code), HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, String>>() {
        });

        logger.info("Entity : {} ", entity);


        if(entity.getStatusCodeValue() == 200) {
            Map<String, String> responseBody = entity.getBody();
            String accessToken = responseBody.get("access_token");

            if(accessToken != null && !accessToken.isEmpty()) {
                request.getSession().setAttribute("accessToken", accessToken);
                return "redirect:/" + redirectUrl;
            }
        }

        return "redirect:/";
    }
}
