package connect.oz.reservation.login.service;

import connect.oz.reservation.login.domain.Users;
import connect.oz.reservation.login.dto.NaverLoginUserDto;

public interface LoginService {
    public Users login(NaverLoginUserDto naverLoginUserDto);
}
