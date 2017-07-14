package kr.or.connect.reservation.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.DetailProductDto;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getAllProduct(int limit, int offset) {
		return dao.selectAllProduct(limit, offset);
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getProductsByCategoryId(Long id, int limit, int offset) {
		return dao.selectProductsByCategoryId(id, limit, offset);
	}

	@Override
	public DetailProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}