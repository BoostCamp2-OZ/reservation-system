package connect.oz.reservation.category.service;

import connect.oz.reservation.category.dao.CategoryDao;
import connect.oz.reservation.category.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> selectCategories() {
        return categoryDao.selectCategories();
    }
}
