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
import connect.oz.reservation.login.domain.Users;
import connect.oz.reservation.reservation.dto.MyReservationDto;
import connect.oz.reservation.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public Long insertReservation(@AuthUser Users user, @Valid @RequestBody Reservation reservation) {

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
    
    @GetMapping("/my")
    public List<MyReservationDto> getMyReservations(HttpSession session) {
        Users user = (Users) session.getAttribute("loginedUser");
        return reservationService.selectReservation(user.getId());
    }

    @PutMapping
    public int updateMyReservation(@RequestBody MyReservationDto reservation) {
        System.out.println(reservation.toString());
        return reservationService.updateReservation(reservation);
    }

}
