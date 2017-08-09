package connect.oz.reservation.product.controller;

import connect.oz.reservation.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/categories/{categoryId}/offset/{offset}")
    public Map<String, Object> selectProducts(Long categoryId, int offset) {
        return productService.selectProducts(categoryId, offset);
    }

}
