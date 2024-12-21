package javaweb.cart.dao;

import java.util.List;

import javaweb.cart.model.entity.Order;
import javaweb.cart.model.entity.OrderItem;

public interface OrderDAO {
	Integer addOrder(Integer userId); // 建立訂單(主檔), 回傳訂單編號
	void addOrderItem(Integer orderId, Integer productId, Integer quantity); // 建立訂單項目(明細檔)
	
	List<Order> findAllOrdersByUserId(Integer userId); // 查詢使用者的訂單
	List<OrderItem> findAllOrderItemsByOrderId(Integer orderId); // 查詢 orderId 的明細
}
