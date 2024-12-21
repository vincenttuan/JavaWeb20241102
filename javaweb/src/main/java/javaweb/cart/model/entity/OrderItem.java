package javaweb.cart.model.entity;

public class OrderItem {
	private Integer ItemId;
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
	
	public Integer getItemId() {
		return ItemId;
	}
	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
