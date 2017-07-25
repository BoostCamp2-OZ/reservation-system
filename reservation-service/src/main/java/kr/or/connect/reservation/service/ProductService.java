package kr.or.connect.reservation.service;

import java.util.Map;

public interface ProductService {
	public Map<String, Object> getAllProduct(int limit, int offset);
	public Map<String, Object> getProductsByCategoryId(Long id, int limit, int offset);
	public Map<String, Object> getProductById(Long id);
	public Map<String, Object> getProductPreviewComments(Long id);
	public Map<String, Object> getReservableProduct(Long id);
}
