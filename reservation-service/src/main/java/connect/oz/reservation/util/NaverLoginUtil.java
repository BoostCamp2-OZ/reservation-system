package connect.oz.reservation.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;

@Component
@PropertySource("classpath:/naverapi.properties")
public class NaverLoginUtil {

    @Value("${naverapi.config.client-id}")
    private String clientId;

    @Value("${naverapi.config.client-secret}")
    private String clientSecret;

    @Value("${naverapi.login.request-url}")
    private String requestUrl;

    @Value("${naverapi.login.request-oauth-url}")
    private String reqestOauthUrl;

    @Value("${naverapi.login.login-callback-url}")
    private String loginCallbackUrl;

    @Value("${naverapi.login.request-user-info-url}")
    private String requestUserInfoUrl;


    public String generateState() {
        SecureRandom state = new SecureRandom();
        return new BigInteger(130, state).toString(32);
    }

    /**
     * 로그인 인증 콜백 URL 리턴 메서드
     *
     * @param state
     * @return
     */
    public String getOauthCallbackURL(String state) {
        return requestUrl + "client_id=" + clientId + "&response_type=code" + "&redirect_uri=" + loginCallbackUrl
                + "&state=" + state;
    }

    /**
     * AccessToken 발급 받는 URL 리턴 메서드
     *
     * @param state
     * @param code
     * @return
     */
    public String getAccessTokenUrl(String state, String code) {
        return reqestOauthUrl + "client_id=" + clientId + "&client_secret=" + clientSecret
                + "&grant_type=authorization_code" + "&state=" + state + "&code=" + code + "&service_provider=NAVER";
    }

    /**
     * 다른아이디로 로그인 할 경우 재로그인 URL 리턴 메서드
     */
    public String reAuthenticateUrl(String state) {
        return requestUrl + "client_id=" + clientId + "&response_type=code" + "&redirect_uri=" + loginCallbackUrl
                + "&state=" + state + "&auth_type=reauthenticate";
    }

    public String getProfileUrl(){
        return requestUserInfoUrl;
    }
}
