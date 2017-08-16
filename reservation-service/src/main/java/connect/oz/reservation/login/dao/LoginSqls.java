package connect.oz.reservation.login.dao;

public class LoginSqls {
    final static String SELECT_USER_BY_SNS_ID =
            "SELECT U.id, U.email, U.nickname, U.tel, U.username "
                    + " FROM users AS U "
                    + " WHERE U.sns_id = :snsId";
}
