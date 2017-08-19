package connect.oz.reservation.reservation.service;

import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.reservation.domain.Reservation;

public interface ReservationService {
    DetailProductDto selectReservableProduct(Long productId);
    long insertReservation(Reservation reservation);
}
