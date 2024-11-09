<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String myId = String.valueOf(request.getAttribute("myId"));
	String myAwardName = String.valueOf(request.getAttribute("myAwardName"));
	String[][] awards = (String[][])request.getAttribute("awards");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>扭蛋機</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
</head>
<body style="padding: 15px">
	<div class="pure-form">
		<fieldset>
			<legend>扭蛋機</legend>
			<table>
				<tr>
					<td valign="top">
						<img src="/javaweb/image/capsule.jpg">
					</td>
					<td valign="top">
						<table class="pure-table">
							<thead>
								<tr>
									<th>編號</th><th>名稱</th><th>庫存</th>
								</tr>
							</thead>
							<tbody>
								<% for(String[] award : awards) { %>
									<tr><td><%=award[0] %></td><td><%=award[1] %></td><td><%=award[2] %></td></tr>	
								<% } %>
							</tbody>
						</table>
						<p />
						<a href="" class="pure-button pure-button-primary">開始扭蛋</a> 
						獎號: <%=myId %> 獎項: <%=myAwardName %> 
					</td>
				</tr>
			</table>
			
		</fieldset>
	</div>
</body>
</html>