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
						<table class="pure-table pure-table-bordered">
							<thead>
								<tr>
									<th>刪除</th><th>Index</th><th>商品ID</th>
									<th>商品名稱</th><th>商品價格</th><th>商品照片</th>
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