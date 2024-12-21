package javaweb.cart.model.dto;

import java.util.ArrayList;
import java.util.List;

import javaweb.cart.model.entity.OrderItem;

public class OrderDTO {
	private Integer orderId;
	private Integer userId;
	private List<OrderItem> items = new ArrayList<>();
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	
	
	
}
