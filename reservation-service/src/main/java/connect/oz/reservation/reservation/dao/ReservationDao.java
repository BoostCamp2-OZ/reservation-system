package connect.oz.reservation.reservation.dao;

import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.reservation.domain.Reservation;
import connect.oz.reservation.reservation.dto.MyReservationDto;
import java.util.List;

public interface ReservationDao {
    long insertReservation(Reservation reservation);
    DetailProductDto selectReservableProduct(Long productId);
    List<MyReservationDto> selectReservationByUserId(long userId);
    int updateReservation(long id, int type);
}
