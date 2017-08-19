package connect.oz.reservation.reservation.service;

import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.reservation.domain.Reservation;
import connect.oz.reservation.reservation.dto.MyReservationDto;

import java.util.List;
public interface ReservationService {
    DetailProductDto selectReservableProduct(Long productId);
    long insertReservation(Reservation reservation);
    public List<MyReservationDto> selectReservation(long userId);
    public int updateReservation(MyReservationDto reservation);
}
