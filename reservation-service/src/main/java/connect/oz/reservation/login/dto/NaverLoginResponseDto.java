package connect.oz.reservation.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NaverLoginResponseDto {

    private String message;
    @JsonProperty("response")
    private NaverLoginUserDto user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NaverLoginUserDto getUser() {
        return user;
    }

    public void setUser(NaverLoginUserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "NaverLoginResponseDto{" +
                "message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
