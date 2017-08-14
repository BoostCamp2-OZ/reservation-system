package connect.oz.reservation.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    @GetMapping("/products/{id}")
    public String getReserve(@PathVariable("id") Long productId){
        return "reserve";
    }
}
