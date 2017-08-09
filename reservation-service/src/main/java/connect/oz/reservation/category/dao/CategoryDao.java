package connect.oz.reservation.category.dao;

import connect.oz.reservation.category.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> selectCategories();
}
