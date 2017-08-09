package connect.oz.reservation.dao;

import connect.oz.reservation.config.RootApplicationContextConfig;
import connect.oz.reservation.product.Dto.SimpleProductDto;
import connect.oz.reservation.product.dao.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void shouldSelectProducts() {
        int offset = 0;
        List<SimpleProductDto> list = productDao.selectProducts(offset);
        Assert.assertNotNull(list);
    }

    @Test
    public void shouldSelectProductsByCategoryId() {
        Long categoryId = 1L;
        int offset = 0;
        List<SimpleProductDto> list = productDao.selectProductsByCategoryId(categoryId, offset);
        Assert.assertNotNull(list);
    }

    @Test
    public void shouldSelectProductCount() {
        Integer count = productDao.selectProductCount();
        Assert.assertNotNull(count);
    }

    @Test
    public void shouldSelectProductCountByCategoryId() {
        Long categoryId = 1L;
        Integer count = productDao.selectProductCountByCategoryId(categoryId);
        Assert.assertNotNull(count);
    }
}
