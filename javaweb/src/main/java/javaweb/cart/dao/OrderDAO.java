package javaweb.cart.dao;

public interface OrderDAO {
	Integer addOrder(Integer userId); // 建立訂單(主檔), 回傳訂單編號
	void addOrderItem(Integer orderId, Integer productId, Integer quantity); // 建立訂單項目(明細檔)
	
}
