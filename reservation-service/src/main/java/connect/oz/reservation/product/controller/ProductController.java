package connect.oz.reservation.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/")
    public String getMainpage() {
        return "mainpage";
    }

//    @GetMapping("/detail")
//    public String getDetail() {
//        return "detail";
//    }


}
