package connect.oz.reservation.login.dao;

import connect.oz.reservation.login.domain.Users;

public interface LoginDao {
    public Users selectBySnsId(long snsId);
}
