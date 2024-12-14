<%@page import="javaweb.cart.model.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品列表管理</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/cart/menu.jspf"  %>
		<!-- content -->
		<div style="padding: 15px" class="pure-form">
			<table>
				<td valign="top">
					<fieldset>
						<legend>商品表單</legend>
						<form enctype="multipart/form-data" method="post" action="/javaweb/product/add">
							商品名稱:<input type="text" name="productName" required="true"><p />
							商品價格:<input type="number" name="price" required="true"><p />
							商品庫存:<input type="number" name="qty" required="true"><p />
							商品照片:<input type="file" name="productImage" required="true"><p />
							<button type="submit">新增商品</button>
						</form>
					</fieldset>	
				</td>
				<td valign="top">
					<fieldset>
						<legend>商品列表</legend>
						<table class="pure-table">
							<thead>
								<tr>
									<th>商品ID</th><th>商品名稱</th><th>商品價格</th><th>商品庫存</th><th>商品照片</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
					</fieldset>
				</td>
			</table>
			
			
		</div>
	</body>
</html>