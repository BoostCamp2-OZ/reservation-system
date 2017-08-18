package connect.oz.reservation.reservation.controller;

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

    private ReservationService reservationService;

    @Autowired
    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
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
