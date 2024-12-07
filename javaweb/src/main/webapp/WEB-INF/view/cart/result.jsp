<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String resultTitle = request.getAttribute("resultTitle") + "";
	String resultMessage = request.getAttribute("resultMessage") + "";
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title><%=resultTitle %></title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/cart/menu.jspf"  %>
		<!-- content -->
		<div style="padding: 15px">
			<h1><%=resultMessage %></h1>
		</div>
	</body>
</html>