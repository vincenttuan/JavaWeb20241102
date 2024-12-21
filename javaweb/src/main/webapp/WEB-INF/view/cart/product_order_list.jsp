<%@page import="javaweb.cart.model.dto.ProductDTO"%>
<%@page import="javaweb.cart.model.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	List<ProductDTO> productDTOs = null;
	List<ProductDTO> cart = null;
	
	// 取得該商品在購物車中的數量
	int getProductAmountInCart(Integer productId) {
		if (cart == null) return 0;
		// 取得該商品在購物車中的數量
		long count = cart.stream().filter(dto -> dto.getProductId().equals(productId)).count();
		return (int)count;
	}
%>

<%
	productDTOs = (List<ProductDTO>)request.getAttribute("productDTOs");
	
	if(session.getAttribute("cart") == null) {
		cart = null;
	}
	
	// 取得購物車 
	if(session.getAttribute("cart") != null) {
		cart = (List<ProductDTO>)session.getAttribute("cart");
	}
	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品訂單列表管理</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
			#preview {
				margin-top: 10px;
				max-width: 200px;
				max-height: 200px;
				border: 1px solid #ddd;
				padding: 5px;
			}
			.products-container {
				display: flex;
				flex-wrap: wrap;
				gap: 10px; /* 商品之間的間距 */
			}
			.product-name {
				font-size: 20px;
				font-weight: blod;
				color: #000000;
			}
			.product-price {
				font-size: 35px;
				font-weight: blod;
				color: #D9006C;
			}
		</style>
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/cart/menu.jspf"  %>
		<!-- content -->
		<div style="padding: 15px" class="pure-form">
			<fieldset>
				<legend>商品訂單列表</legend>
					<div class="products-container">
						<% for(ProductDTO productDTO : productDTOs) { %>
							<div class="product-item" onmouseover="this.style.backgroundColor='#E0E0ff'" 
							    onmouseout="this.style.backgroundColor=''">
								<img width="200" src='data:image/png;base64,<%=productDTO.getImageBase64() %>'>
								<br>
								<p class="product-name"><%=productDTO.getProductName() %>(No.<%=productDTO.getProductId() %>)<p>
								<p class="product-price">$<%=productDTO.getPrice() %><p />
								庫存數量:<%=productDTO.getQty() %><p />
								<%
									int amount = productDTO.getQty() - getProductAmountInCart(productDTO.getProductId());
								%>
								可買數量:<%=amount %><p />
								A:<%=productDTO.getQty() %><p />
								B:<%=getProductAmountInCart(productDTO.getProductId()) %><p />
								<a <%=amount == 0 ? "disabled" : "" %> class="pure-button pure-button-primary" href="/javaweb/product/order/add/cart?productId=<%=productDTO.getProductId() %>">加入購物車</a>
							</div>
						<% } %>
					</div>
				</table>
			</fieldset>
	
		</div>
		
	</body>
</html>