<%@ page import="java.util.Random"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 準備獎項
	Map<Integer, String> awards = Map.of(1, "現金10萬元", 2, "禮券2萬元", 3, "禮券5000元", 
			4, "現金500元", 5, "7-11 100元");
	
	// 抽號碼
	Random random = new Random(); // 隨機數
	Integer number = random.nextInt(10) + 1; // 0~9 + 1 => 1..10 的隨機數
	
	// 獎項
	String award = null;
	switch (number) {
		case 1:
		case 2:
		case 3:
		case 4:
			award = awards.get(number);
			break;
		default:
			award = awards.get(5);
	}
	
	// 顯示資料(console)
	System.out.printf("您抽到 %d 號 獎項: %s%n", number, award);

%>
	
	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lottery 抽獎</title>
</head>
<body>
	獎品列表
	<table border="1">
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