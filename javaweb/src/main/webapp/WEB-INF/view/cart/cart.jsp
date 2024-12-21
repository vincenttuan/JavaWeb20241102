<%@page import="javaweb.cart.model.dto.ProductDTO"%>
<%@page import="javaweb.cart.model.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<ProductDTO> cart = (List<ProductDTO>)session.getAttribute("cart");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>購物車</title>
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
						<legend>購物車</legend>
						<table class="pure-table pure-table-bordered">
							<thead>
								<tr>
									<th>刪除</th><th>Index</th><th>商品ID</th>
									<th>商品名稱</th><th>商品價格</th><th>商品照片</th>
								</tr>
							</thead>
							<tbody>
								<% int total = 0; // 總計%>
								<% for(int i=0;i<cart.size();i++) { %>
									<% total += cart.get(i).getPrice(); // 總計資料逐筆類加%>
									<tr onmouseover="this.style.backgroundColor='#E0E0ff'" 
									    onmouseout="this.style.backgroundColor=''">
										<td>
											<a href="/javaweb/product/cart/delete?index=<%=i %>">刪除</a>
										</td>
										<td align="center"><%=i %></td>
										<td align="center"><%=cart.get(i).getProductId() %></td>
										<td><%=cart.get(i).getProductName() %></td>
										<td align="right"><%=cart.get(i).getPrice() %></td>
										<td>
											<img width="100" src='data:image/png;base64,<%=cart.get(i).getImageBase64() %>'>
										</td>
									</tr>
								<% } %>
								<!-- 總計  -->
								<tr>
									<td colspan="4" align="right">總計</td>
									<td align="right"><%=total %></td>
									<td align="center">
										<a class="pure-button pure-button-primary" href="/javaweb/product/cart/submit">
											結帳
										</a>
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</td>
			</table>
			
		</div>
		
	</body>
</html>