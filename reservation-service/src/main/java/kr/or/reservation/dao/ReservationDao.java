package kr.or.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.reservation.dto.ReservationDTO;
import kr.or.reservation.sqls.ReservationSqls;

@Repository
public class ReservationDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationDTO> reservationMapper = BeanPropertyRowMapper.newInstance(ReservationDTO.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

<<<<<<< HEAD
	public ReservationDTO selectOne(int id) {
		Map<String , ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(ReservationSqls.SELECT_ONE,params, reservationMapper);
=======
	public ReservationDTO selectByProductId(int productId) {
		Map<String , ?> params = Collections.singletonMap("productId", productId);
		return jdbc.queryForObject(ReservationSqls.SELECT_BY_PRODUCT_ID,params, reservationMapper);
>>>>>>> 0d95395487ea32084ee49af481f7933ef7c9a78a
	}
	
	public List<Map<String,Object>> selectPrice(int id) {
		Map<String , ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForList(ReservationSqls.SELECT_PRICE, params);
	}
	
}
