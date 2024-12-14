package javaweb.cart.service;

import java.util.List;

import javaweb.cart.model.dto.ProductDTO;

public interface ProductService {
	void add(String productName, String price, String qty, String productImageBase64);
	List<ProductDTO> findAll();
	void delete(Integer productId);
}
