package connect.oz.reservation.dao;

import connect.oz.reservation.category.dao.CategoryDao;
import connect.oz.reservation.category.domain.Category;
import connect.oz.reservation.config.RootApplicationContextConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void shouldSelectCategories() {
        List<Category> list = categoryDao.selectCategories();

        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 5);
    }
}
