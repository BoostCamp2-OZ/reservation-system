package connect.oz.reservation.product.service;

import java.util.Map;

public interface ProductService {

    Map<String, Object> selectProducts(Long categoryId, int offset);

}
