<%@page import="javaweb.cart.model.dto.ProductDTO"%>
<%@page import="javaweb.cart.model.entity.OrderItem"%>
<%@page import="javaweb.cart.model.dto.OrderDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	List<OrderDTO> orderDTOs;
	List<ProductDTO> productDTOs;
	
	ProductDTO getProductDTO(Integer productId) {
		return productDTOs.stream()
						  .filter(p -> p.getProductId().equals(productId))
						  .findAny()
						  .orElse(new ProductDTO());
				
	}
%>

<%
	orderDTOs = (List<OrderDTO>)request.getAttribute("orderDTOs");
	productDTOs = (List<ProductDTO>)request.getAttribute("productDTOs");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>訂單歷史紀錄</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
			#preview {
				margin-top: 10px;
				max-width: 200px;
				max-height: 200px;
				border: 1px solid #ddd;
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/cart/menu.jspf"  %>
		<!-- content -->
		<div style="padding: 15px" class="pure-form">
			<table>
				<td valign="top">
					<fieldset>
						<legend>訂單歷史紀錄</legend>
						<% for(OrderDTO orderDTO : orderDTOs) { %>
						<table class="pure-table pure-table-bordered">
							<thead>
								<tr>
									<th align="center">訂單ID:</th>
									<th align="center"><%=orderDTO.getOrderId() %></th>
									<th align="center">使用者 ID:</th>
									<th align="center"><%=orderDTO.getUserId() %></th>
								</tr>
							</thead>
							<tbody>
								<td colspan="4">
									<!--  明細 -->
									<table class="pure-table pure-table-bordered">
										<thead>
											<th>項目ID</th><th>商品ID</th><th>數量</th>
											<th>商品名稱</th><th>商品價格</th><th>商品圖片</th>
										</thead>
										<tbody>
											<% int total = 0; %>
											<% for(OrderItem item : orderDTO.getItems()) { %>
											<% ProductDTO productDTO = getProductDTO(item.getProductId()); %>
											<tr>
												<td><%=item.getItemId() %></td>
												<td><%=item.getProductId() %></td>
												<td><%=item.getQuantity() %></td>
												<td><%=productDTO.getProductName() %></td>
												<td><%=productDTO.getPrice() %></td>
												<td>
													<img width="50" src='data:image/png;base64,<%=productDTO.getImageBase64() %>'>
												</td>
											</tr>
											<% total += item.getQuantity() * productDTO.getPrice() %>
											<% } %>
											<tr>
												<td align="right">小計</td>
												<td align="right"><%=total %></td>
												<td> </td>
											</tr>
										</tbody>
									</table>
								</td>
							</tbody>
						</table>
						<% } %>
					</fieldset>
				</td>
			</table>
			
		</div>
		
		
		
	</body>
</html>