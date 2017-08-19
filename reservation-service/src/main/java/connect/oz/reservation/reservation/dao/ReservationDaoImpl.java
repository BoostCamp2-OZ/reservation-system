package connect.oz.reservation.reservation.dao;

import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.product.dto.SimpleProductDto;
import connect.oz.reservation.reservation.domain.Reservation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import connect.oz.reservation.reservation.dto.MyReservationDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<SimpleProductDto> rowMapper = BeanPropertyRowMapper.newInstance(SimpleProductDto.class);
    private RowMapper<MyReservationDto> reservationMapper = BeanPropertyRowMapper.newInstance(MyReservationDto.class);

    public ReservationDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction=new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info").usingGeneratedKeyColumns("id");
    }

    @Override
    public long insertReservation(Reservation reservation) {
        SqlParameterSource params=new BeanPropertySqlParameterSource(reservation);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    @Override
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
