package kr.or.connect.reservation.service;

import java.util.Map;

import kr.or.connect.reservation.dto.DetailProductDto;

public interface ProductService {
	public Map<String, Object> getAllProduct(int limit, int offset);
	public Map<String, Object> getProductsByCategoryId(Long id, int limit, int offset);
	
	public DetailProductDto getProductById(Long id);
}
