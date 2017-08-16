package connect.oz.reservation.login.dao;

import connect.oz.reservation.login.domain.Users;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LoginDaoImpl implements  LoginDao{

    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Users> rowMapper = BeanPropertyRowMapper.newInstance(Users.class);
    private SimpleJdbcInsert insertAction;

    public LoginDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction=new SimpleJdbcInsert(dataSource)
                .withTableName("users").usingGeneratedKeyColumns("id");
    }

    public Users selectBySnsId(long snsId) {
        Map<String,Long> params = new HashMap<>();
        params.put("snsId",snsId);
        try{
            return jdbc.queryForObject(LoginSqls.SELECT_USER_BY_SNS_ID, params, rowMapper);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
}
