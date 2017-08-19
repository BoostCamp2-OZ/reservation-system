package connect.oz.reservation.product.dao;

import connect.oz.reservation.product.domain.Image;
import connect.oz.reservation.product.domain.Price;
import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.product.dto.SimpleProductDto;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface ProductDao {
    List<SimpleProductDto> selectProducts(int offset);

    List<SimpleProductDto> selectProductsByCategoryId(Long categoryId, int offset);

    int selectProductCount() throws EmptyResultDataAccessException;

    int selectProductCountByCategoryId(Long categoryId) throws EmptyResultDataAccessException;

    DetailProductDto selectProductById(Long productId);

    List<Image> selectProductImageListById(Long productId);

    List<Price> selectProductPriceListById(Long productId);
}
