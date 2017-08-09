package connect.oz.reservation.product.service;

import connect.oz.reservation.product.Dto.SimpleProductDto;
import connect.oz.reservation.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional(readOnly = true)
    @Override
    public Map<String, Object> selectProducts(Long categoryId, int offset) {
        List<SimpleProductDto> productDtoList = null;
        Map<String, Object> result = new HashMap<String, Object>();

        int count = 0;
        if (categoryId == 0) {
            productDtoList = productDao.selectProducts(offset);
            count = productDao.selectProductCount();
        } else {
            productDtoList = productDao.selectProductsByCategoryId(categoryId, offset);
            count = productDao.selectProductCountByCategoryId(categoryId);
        }

        result.put("products", productDtoList);
        result.put("totalCount", count);

        return result;
    }
}
