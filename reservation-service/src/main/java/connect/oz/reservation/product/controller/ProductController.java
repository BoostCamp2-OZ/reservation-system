package connect.oz.reservation.product.controller;

import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getMainpage() {
        return "mainpage";
    }

    @GetMapping("/products/{id}")
    public String getDetail(@PathVariable("id") Long productId, Model model) {
        DetailProductDto detailProductDto = productService.selectProductById(productId);
        model.addAttribute("product", detailProductDto);

        return "detail";
    }


}
