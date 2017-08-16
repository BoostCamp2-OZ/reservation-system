package connect.oz.reservation.login.dto;

public class NaverLoginResponseDto {
    private String resultCode;
    private String message;
    private NaverLoginUserDto user;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

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
                "resultCode='" + resultCode + '\'' +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
