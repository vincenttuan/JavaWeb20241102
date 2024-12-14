package javaweb.cart.service.impl;

import java.util.List;

import javaweb.cart.dao.ProductDAO;
import javaweb.cart.dao.impl.ProductDAOImpl;
import javaweb.cart.model.dto.ProductDTO;
import javaweb.cart.model.entity.Product;
import javaweb.cart.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	public void add(ProductDTO productDTO) {
		// 將 productDTO 轉 product
		Product product = mapToProduct(productDTO);
		productDAO.add(product);
	}

	@Override
	public List<ProductDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ProductDTO 轉 Product 物件的方法
	private Product mapToProduct(ProductDTO productDTO) {
		Product product = new Product();
		// 將 productDTO 的屬性內容逐一設定到 product 屬性中
		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		product.setQty(productDTO.getQty());
		product.setImageBase64(productDTO.getImageBase64());
		return product;
	}
	
	// Product 轉 ProductDTO 物件的方法
	private ProductDTO mapToProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductName(product.getProductName());
		productDTO.setPrice(product.getPrice());
		productDTO.setQty(product.getQty());
		productDTO.setImageBase64(product.getImageBase64());
		// 重要 !! (自訂欄位)
		Integer total = product.getPrice() * product.getQty();
		productDTO.setTotal(total);
		
		return productDTO;
	}
	

}
