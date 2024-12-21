<%@page import="javaweb.cart.model.entity.OrderItem"%>
<%@page import="javaweb.cart.model.dto.OrderDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<OrderDTO> orderDTOs = (List<OrderDTO>)session.getAttribute("orderDTOs");
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
								<tr>
									<th colspan="4" align="center">訂單明細</th>
								</tr>
							</thead>
							<tbody>
								<td colspan="4">
									<!--  明細 -->
									<table class="pure-table pure-table-bordered">
										<thead>
											<th>項目ID</th><th>商品ID</th><th>數量</th>		
										</thead>
										<tbody>
											<% for(OrderItem item : orderDTO.getItems()) { %>
											<tr>
												<td><%=item.getItemId() %></td>
												<td><%=item.getProductId() %></td>
												<td><%=item.getQuantity() %></td>
											</tr>
											<% } %>
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