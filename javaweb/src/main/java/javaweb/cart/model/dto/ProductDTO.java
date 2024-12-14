package javaweb.cart.model.dto;

public class ProductDTO {
	private Integer productId;  // 對應 entity.Product 的 productId 欄位
	private String productName; // 對應 entity.Product 的 productName 欄位
	private Integer price;      // 對應 entity.Product 的 price 欄位
	private Integer qty;        // 對應 entity.Product 的 qty 欄位
	private String imageBase64; // 對應 entity.Product 的 imageBase64 欄位
	private Integer total;      // 自訂欄位. 目的:計算總和 price * qty
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getImageBase64() {
		return imageBase64;
	}
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
	
}
