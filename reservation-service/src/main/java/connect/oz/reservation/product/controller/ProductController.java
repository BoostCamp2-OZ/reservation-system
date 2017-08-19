package connect.oz.reservation.product.controller;

import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getMainpage() {
        return "mainpage";
    }

    @GetMapping("/products/{productId:[\\\\\\d]+}")
    public String getDetail(@PathVariable("productId") Long productId, Model model) {
        DetailProductDto detailProductDto = productService.selectProductById(productId);
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String now = formatter.format(Calendar.getInstance().getTime());
        Timestamp ts = Timestamp.valueOf(now);
        if(detailProductDto.getSalesEnd().compareTo(ts)<0){
            model.addAttribute("salesEnd", true);
        }else{
            model.addAttribute("salesEnd", false);
        }
        model.addAttribute("product", detailProductDto);

        return "detail";
    }

}
