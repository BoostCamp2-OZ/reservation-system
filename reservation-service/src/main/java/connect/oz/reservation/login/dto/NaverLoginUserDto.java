package connect.oz.reservation.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import connect.oz.reservation.login.domain.Users;

import java.io.Serializable;

public class NaverLoginUserDto extends Users implements Serializable {

    @Override
    @JsonProperty("name")
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    @JsonProperty("id")
    public void setSnsId(long snsId) {
        this.snsId = snsId;
    }

    @Override
    @JsonProperty("sns_profile")
    public String getSnsProfile() {
        return snsProfile;
    }

    @Override
    public String toString() {
        return "NaverLoginUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", nickname='" + nickname + '\'' +
                ", snsId='" + snsId + '\'' +
                ", snsType='" + snsType + '\'' +
                ", snsProfile='" + snsProfile + '\'' +
                ", adminFlag=" + adminFlag +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}