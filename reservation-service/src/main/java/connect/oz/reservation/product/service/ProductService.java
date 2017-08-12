package connect.oz.reservation.product.service;

import connect.oz.reservation.product.Dto.DetailProductDto;

import java.util.Map;

public interface ProductService {

    Map<String, Object> selectProducts(Long categoryId, int offset);
    DetailProductDto selectProductById(Long productId);
}
