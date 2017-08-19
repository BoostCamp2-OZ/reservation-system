package connect.oz.reservation.reservation.controller;

import connect.oz.reservation.annotaion.AuthUser;
import connect.oz.reservation.login.domain.Users;
import connect.oz.reservation.reservation.domain.Reservation;
import connect.oz.reservation.reservation.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private ReservationService reservationService;

    @Autowired
    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Long insertReservation(@AuthUser Users user,@Valid @RequestBody Reservation reservation) {

        reservation.setUserId(user.getId());

        Timestamp now = new Timestamp(System.currentTimeMillis());

        reservation.setReservationType(1);
        reservation.setCreateDate(now);
        reservation.setReservationDate(now);
        reservation.setModifyDate(now);

        logger.info(reservation.toString());

        long reservationId = reservationService.insertReservation(reservation);

        return reservationId;

    }
}
