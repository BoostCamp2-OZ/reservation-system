package connect.oz.reservation.reservation.dao;

import connect.oz.reservation.reservation.dto.MyReservationDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReservationDaoImpl implements ReservationDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<MyReservationDto> reservationMapper = BeanPropertyRowMapper.newInstance(MyReservationDto.class);

    public ReservationDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction=new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info").usingGeneratedKeyColumns("id");
    }

    public List<MyReservationDto> selectReservationByUserId(long userId){
        Map<String,?> params= Collections.singletonMap("id", userId);
        return jdbc.query(ReservationSqls.SELECT_RESERVATION, params,reservationMapper);
    }

    @Override
    public int updateReservation(long id, int type) {
        Map<String,Object> params = new HashMap();
        params.put("id", id);
        params.put("type",type);
        params.put("cancel_type", 4);
        return jdbc.update(ReservationSqls.UPDATE_RESERVATION, params);
    }
}
