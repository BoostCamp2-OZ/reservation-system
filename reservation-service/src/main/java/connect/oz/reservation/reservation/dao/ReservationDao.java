package connect.oz.reservation.reservation.dao;

import connect.oz.reservation.reservation.dto.MyReservationDto;

import java.util.List;

public interface ReservationDao {
    List<MyReservationDto> selectReservationByUserId(long userId);
    int updateReservation(long id, int type);
}
