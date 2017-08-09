package connect.oz.reservation.product.dao;

import connect.oz.reservation.product.Dto.SimpleProductDto;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface ProductDao {
    List<SimpleProductDto> selectProducts(int offset);

    List<SimpleProductDto> selectProductsByCategoryId(Long categoryId, int offset);

    int selectProductCount() throws EmptyResultDataAccessException;

    int selectProductCountByCategoryId(Long categoryId) throws EmptyResultDataAccessException;

}
