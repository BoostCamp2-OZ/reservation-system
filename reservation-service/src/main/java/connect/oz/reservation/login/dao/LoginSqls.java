package connect.oz.reservation.login.dao;

public class LoginSqls {
    final static String SELECT_USER_BY_SNS_ID =
            "SELECT U.id, U.email, U.nickname, U.tel, U.username "
                    + " FROM users AS U "
                    + " WHERE U.sns_id = :snsId";
    final static String UPDATE_USER =
            "UPDATE users"
                    + " SET sns_profile= :snsProfile, sns_id= :snsId, nickname= :nickname, email= :email, "
                    + " username= :username, create_date= sysdate()"
                    + " WHERE sns_id= :snsId";
}
