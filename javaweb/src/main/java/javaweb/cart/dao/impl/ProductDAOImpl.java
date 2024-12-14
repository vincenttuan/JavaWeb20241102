package javaweb.cart.dao.impl;

import java.util.List;

import javaweb.cart.dao.ProductDAO;
import javaweb.cart.model.entity.Product;

public class ProductDAOImpl extends BaseDAO implements ProductDAO {

	@Override
	public void add(Product product) {
		String sql = "insert into product(product_name, price, qty, image_base64) values(?, ?, ?, ?)";
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
