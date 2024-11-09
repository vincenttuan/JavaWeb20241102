<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 得到從 Lottery2Servlet 所傳來的資料
	Object number = request.getAttribute("number");
	Object award = request.getAttribute("award");
%>
	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lottery 抽獎</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
</head>
<body style="padding: 15px">
	獎品列表
	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>獎號</th>
				<th>獎項</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>現金10萬元</td>
			</tr>
			<tr>
				<td>2</td>
				<td>禮券2萬元</td>
			</tr>
			<tr>
				<td>3</td>
				<td>禮券5000元</td>
			</tr>
			<tr>
				<td>4</td>
				<td>現金500元</td>
			</tr>
			<tr>
				<td>5~10</td>
				<td>7-11 100元</td>
			</tr>
		</tbody>
	</table>
	<p />
	您抽到 <%=number %> 號 獎項: <%=award %>
</body>
</html>