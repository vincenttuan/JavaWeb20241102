package javaweb.cart.dao;

import java.util.List;

import javaweb.cart.model.entity.Product;

public interface ProductDAO {
	void add(Product product); // 新增紀錄
	//void update(Integer productId, Product newProduct); // 修改紀錄, 根據指定 productId
	//void updateQty(Integer productId, Integer amount);  // 修改庫存紀錄, 根據指定 productId 與數量
	//void delete(Integer productId); // 刪除庫存, 根據指定 productId
	List<Product> findAll(); // 全部查詢
	//Product getById(Integer productId); // 單筆查詢
}
