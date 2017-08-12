package connect.oz.reservation.product.service;

import connect.oz.reservation.file.domain.File;
import connect.oz.reservation.product.Dto.DetailProductDto;
import connect.oz.reservation.product.Dto.SimpleProductDto;
import connect.oz.reservation.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try{
            if (categoryId == 0) {
                productDtoList = productDao.selectProducts(offset);
                count = productDao.selectProductCount();
            } else {
                productDtoList = productDao.selectProductsByCategoryId(categoryId, offset);
                count = productDao.selectProductCountByCategoryId(categoryId);
            }
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        result.put("products", productDtoList);
        result.put("totalCount", count);
        return result;
    }

    @Override
    public DetailProductDto selectProductById(Long productId) {
        DetailProductDto detailProductDto = productDao.selectProductById(productId);
        List<File> files = productDao.selectProductImageListById(productId);
        detailProductDto.setFiles(files);
        return detailProductDto;
    }
}
