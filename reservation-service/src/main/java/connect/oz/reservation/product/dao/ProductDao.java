package connect.oz.reservation.product.dao;

import connect.oz.reservation.product.Dto.SimpleProductDto;

import java.util.List;

public interface ProductDao {
    List<SimpleProductDto> selectProducts(int offset);

    List<SimpleProductDto> selectProductsByCategoryId(Long categoryId, int offset);

    int selectProductCount();

    int selectProductCountByCategoryId(Long categoryId);
}
