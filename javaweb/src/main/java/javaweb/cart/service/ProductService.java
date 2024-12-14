package javaweb.cart.service;

import java.util.List;

import javaweb.cart.model.dto.ProductDTO;

public interface ProductService {
	void add(ProductDTO productDTO);
	List<ProductDTO> findAll();
}
