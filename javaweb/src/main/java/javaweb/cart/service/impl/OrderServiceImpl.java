package javaweb.cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import javaweb.cart.dao.OrderDAO;
import javaweb.cart.dao.impl.OrderDAOImpl;
import javaweb.cart.model.dto.OrderDTO;
import javaweb.cart.model.dto.ProductDTO;
import javaweb.cart.model.entity.Order;
import javaweb.cart.model.entity.OrderItem;
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

	@Override
	public List<OrderDTO> findAllOrdersByUserId(Integer userId) {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		// 取得訂單主檔紀錄
		List<Order> orders = orderDAO.findAllOrdersByUserId(userId);
		for(Order order : orders) {
			OrderDTO orderDTO = new OrderDTO();
			// 訂單資訊
			orderDTO.setOrderId(order.getOrderId());
			orderDTO.setUserId(order.getUserId());
			// 訂單明細
			for(OrderItem item : orderDAO.findAllOrderItemsByOrderId(order.getOrderId())) {
				orderDTO.getItems().add(item);
			}
			// 注入
			orderDTOs.add(orderDTO);
		}
		
		return orderDTOs;
	}

}
