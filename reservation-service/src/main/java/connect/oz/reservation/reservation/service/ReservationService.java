package connect.oz.reservation.reservation.service;

import connect.oz.reservation.reservation.dto.MyReservationDto;

import java.util.List;

public interface ReservationService {
    public List<MyReservationDto> selectReservation(long userId);
    public int updateReservation(MyReservationDto reservation);
}
