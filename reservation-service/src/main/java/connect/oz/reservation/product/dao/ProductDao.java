package connect.oz.reservation.product.dao;

import connect.oz.reservation.file.domain.FileDomain;
import connect.oz.reservation.product.Dto.DetailProductDto;
import connect.oz.reservation.product.Dto.SimpleProductDto;
import connect.oz.reservation.product.domain.Image;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface ProductDao {
    List<SimpleProductDto> selectProducts(int offset);

    List<SimpleProductDto> selectProductsByCategoryId(Long categoryId, int offset);

    int selectProductCount() throws EmptyResultDataAccessException;

    int selectProductCountByCategoryId(Long categoryId) throws EmptyResultDataAccessException;

    public DetailProductDto selectProductById(Long productId);

    public List<Image> selectProductImageListById(Long productId);

}
