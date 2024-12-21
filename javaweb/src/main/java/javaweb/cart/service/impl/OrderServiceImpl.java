package javaweb.cart.service.impl;

import java.util.List;

import javaweb.cart.dao.OrderDAO;
import javaweb.cart.dao.impl.OrderDAOImpl;
import javaweb.cart.model.dto.ProductDTO;
import javaweb.cart.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private OrderDAO orderDAO = new OrderDAOImpl();
	
	@Override
	public void addOrder(Integer userId, List<ProductDTO> cart) {
		Integer quantity = 1; // 固定數量
		// 新增訂單主檔後得到 orderId
		Integer orderId = orderDAO.addOrder(userId);
		// 逐一新增訂單明細檔 
		for(ProductDTO item : cart) {
			orderDAO.addOrderItem(orderId, item.getProductId(), quantity);
		}
	}

}
