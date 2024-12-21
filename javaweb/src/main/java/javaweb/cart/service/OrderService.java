package javaweb.cart.service;

import java.util.List;

import javaweb.cart.model.dto.ProductDTO;

public interface OrderService {
	void addOrder(Integer userId, List<ProductDTO> cart); // 建立訂單(使用者id, 購物車資料)
}
