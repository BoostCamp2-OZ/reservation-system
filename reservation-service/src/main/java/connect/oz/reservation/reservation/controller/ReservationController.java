package connect.oz.reservation.reservation.controller;

import connect.oz.reservation.annotaion.AuthUser;
import connect.oz.reservation.login.domain.Users;
import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.reservation.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    @GetMapping("/products/{productId}")
    public String getReservableProduct(@PathVariable("productId") Long productId, @AuthUser Users user, Model model) {
        DetailProductDto detailProductDto = reservationService.selectReservableProduct(productId);
        logger.info("DetailProductDto : "+detailProductDto.toString());
        logger.info("User : "+user.toString());
        model.addAttribute("product",detailProductDto);
        model.addAttribute("user",user);
        return "reserve";
    }

    @GetMapping("/my")
    public String getMyReserve() {
        return "myreservation";
    }
}
