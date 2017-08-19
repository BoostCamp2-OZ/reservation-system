package connect.oz.reservation.reservation.dao;

import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.reservation.domain.Reservation;

public interface ReservationDao {
    long insertReservation(Reservation reservation);
    //DetailProductDto selectReservableProduct(Long productId);
}
