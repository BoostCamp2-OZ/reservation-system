package connect.oz.reservation.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @RequestMapping("/reviewWrite/{productId:[\\d]+}")
    public ModelAndView reviewWrite(@PathVariable int productId) {
        ModelAndView mav = new ModelAndView("reviewWrite");
        mav.addObject("id", productId);
        return mav;
    }
}
