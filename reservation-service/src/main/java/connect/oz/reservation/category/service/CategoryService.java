package connect.oz.reservation.category.service;

import connect.oz.reservation.category.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> selectCategories();
}
