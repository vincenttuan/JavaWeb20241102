package javaweb.cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javaweb.cart.dao.ProductDAO;
import javaweb.cart.model.entity.Product;

public class ProductDAOImpl extends BaseDAO implements ProductDAO {

	@Override
	public void add(Product product) {
		String sql = "insert into product(product_name, price, qty, image_base64) values(?, ?, ?, ?)";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// 配置資料到 ?
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getQty());
			pstmt.setString(4, product.getImageBase64());
			
			// 執行新增
			int rowcount = pstmt.executeUpdate();
			System.out.println("新增成功筆數:" + rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
