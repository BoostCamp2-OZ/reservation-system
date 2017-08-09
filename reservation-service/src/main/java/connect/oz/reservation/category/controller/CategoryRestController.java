package connect.oz.reservation.category.controller;

import connect.oz.reservation.category.domain.Category;
import connect.oz.reservation.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> selectCategories() {
        return categoryService.selectCategories();
    }
}
