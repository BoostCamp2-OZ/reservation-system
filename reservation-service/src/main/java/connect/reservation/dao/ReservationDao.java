package connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import connect.reservation.domain.ReservationInfo;
import connect.reservation.dto.Reservation;
import connect.reservation.dto.ReservationCount;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc; // sql 을 실행하기 위해 사용되는 객체
    private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체
    private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class); // 칼럼 이름을 보통 user_name 과 같이 '_'를 활용하는데 자바는 낙타표기법을 사용한다 이것을 자동 맵핑한다.
    private RowMapper<Reservation> reservationRowMapper = BeanPropertyRowMapper.newInstance(Reservation.class);
    
    // Spring은 생성자를 통하여 주입을 하게 된다.
    public ReservationDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); // Datasource를 주입
        this.insertAction = new SimpleJdbcInsert(dataSource)  // Datasource를 주입
                .withTableName("reservation_info")   // table명을 지정
                .usingGeneratedKeyColumns("id"); // pk 칼럼을 지정
    }
    
    public int insert(ReservationInfo reservationInfo){
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo); 
        return insertAction.executeAndReturnKey(params).intValue();	
    }
    
    public List<Reservation> select(int userId) {
    	Map<String, Integer> params = new HashMap<>();
    	params.put("user_id", userId);
    	return jdbc.query(ReservationInfoSqls.SELECT_BY_USER_ID, params, reservationRowMapper);
    }
    
    public List<ReservationCount> selectCount(int userId) {
    	Map<String, Integer> params = new HashMap<>();
    	params.put("user_id", userId);
    	RowMapper<ReservationCount> rm = BeanPropertyRowMapper.newInstance(ReservationCount.class);
    	return jdbc.query(ReservationInfoSqls.SELECT_COUNT, params, rm);
    }
    
}
