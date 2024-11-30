<%@page import="javaweb.cart.model.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<UserDTO> userDTOs = (List<UserDTO>)request.getAttribute("userDTOs");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>使用者列表</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/cart/menu.jspf"  %>
		<!-- content -->
		<div class="pure-table">
			<fieldset>
				<legend>使用者列表</legend>
				<table class="pure-table">
					<thead>
						<tr>
							<th>序號</th><th>帳號</th><th>Email</th><th>Email 驗證</th>
						</tr>
					</thead>
					<tbody>
						<% for(UserDTO userDTO : userDTOs) { %>
							<tr>
								<td><%=userDTO.getId() %></td>
								<td><%=userDTO.getUsername() %></td>
								<td><%=userDTO.getEmail() %></td>
								<td><%=userDTO.getCompleted()?"驗證成功":"尚未驗證" %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>