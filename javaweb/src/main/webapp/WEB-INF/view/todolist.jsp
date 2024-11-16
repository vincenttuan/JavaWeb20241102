<%@page import="javaweb.model.entity.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Todo> todos = (List<Todo>)request.getAttribute("todos");
%>    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>My Todo List</title>
	<!-- 引入 Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-light">
	<div class="container text-center">
		<h1>My Todo List</h1>
		<!-- Todo List 新增 -->
		<form method="post" action="/javaweb/todolist/add">
			<fieldset>
				<legend>新增工作項目</legend>
				序號: <input type="number" name="id" required placeholder="請輸入 ID" /><p />
				項目: <input type="text" name="text" required placeholder="請輸入工作項目" /><p />
				<button type="submit">新增</button>
			</fieldset>
		</form>
		<!-- Todo List 列表 -->
		<ul>
			<% for(Todo todo : todos) { %>
				<li style="text-decoration: <%=todo.getComppleted() ? "line-through" : "" %>;">
					<%=todo.getId() %> - <%=todo.getText() %> 
					<input type="checkbox" <%=todo.getComppleted() ? "checked" : "" %> 
						   onclick="location.href='/javaweb/todolist/update?id=<%=todo.getId() %>&complete=this.value';" /> 
					<a href="/javaweb/todolist/delete?id=<%=todo.getId() %>">刪除</a>
				</li>
			<% } %>
		</ul>
	</div>
	<!-- 引入 Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>