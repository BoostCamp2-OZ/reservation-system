package connect.oz.reservation.product.controller;

import connect.oz.reservation.product.Dto.DetailProductDto;
import connect.oz.reservation.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/categories/{categoryId}/offset/{offset}")
    public Map<String, Object> selectProducts(@PathVariable("categoryId") Long categoryId, @PathVariable("offset") int offset) {
        return productService.selectProducts(categoryId, offset);
    }

    @GetMapping("/{id}")
    public ModelAndView selectProductById(@PathVariable("id") Long productId, Model model){
        DetailProductDto detailProductDto = productService.selectProductById(productId);

        ModelAndView mav = new ModelAndView("detail");
        mav.addObject("product",detailProductDto);

        return mav;
    }

}
