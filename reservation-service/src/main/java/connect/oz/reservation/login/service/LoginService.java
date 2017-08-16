package connect.oz.reservation.login.service;

import connect.oz.reservation.login.domain.Users;

public interface LoginService {
    boolean login(Users user);

    Users selectUsers(Long id);
}
