package connect.oz.reservation.reservation.dao;

import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.product.dto.SimpleProductDto;
import connect.oz.reservation.reservation.domain.Reservation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<SimpleProductDto> rowMapper = BeanPropertyRowMapper.newInstance(SimpleProductDto.class);


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
}
