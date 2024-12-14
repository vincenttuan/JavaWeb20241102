package javaweb.cart.service.impl;

import java.util.List;

import javaweb.cart.dao.ProductDAO;
import javaweb.cart.dao.impl.ProductDAOImpl;
import javaweb.cart.model.dto.ProductDTO;
import javaweb.cart.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	public void add(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
