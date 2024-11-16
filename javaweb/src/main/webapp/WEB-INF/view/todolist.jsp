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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Todo List</title>
    <!-- 引入 Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-group {
            display: flex;
            align-items: center;
            margin-bottom: 1rem;
        }
        .form-group label {
            width: 100px; /* 控制 label 寬度 */
            margin-right: 1rem; /* 添加與 input 間的距離 */
        }
        .container {
            max-width: 600px; /* 限制容器寬度 */
        }
        .completed {
            text-decoration: line-through;
            color: gray;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-light">
    <div class="container text-center">
        <h1 class="mb-4 text-primary">My Todo List</h1>
        <!-- Todo List 新增 -->
        <form method="post" action="/javaweb/todolist/add" class="p-4 bg-white rounded shadow mb-4">
            <fieldset>
                <legend class="text-primary mb-3">新增工作項目</legend>
                <div class="form-group">
                    <label for="id" class="form-label">序號:</label>
                    <input type="number" id="id" name="id" class="form-control" required placeholder="請輸入 ID" />
                </div>
                <div class="form-group">
                    <label for="text" class="form-label">項目:</label>
                    <input type="text" id="text" name="text" class="form-control" required placeholder="請輸入工作項目" />
                </div>
                <button type="submit" class="btn btn-primary w-100">新增</button>
            </fieldset>
        </form>

        <!-- Todo List 列表 -->
        <ul class="list-group">
            <% for (Todo todo : todos) { %>
                <li class="list-group-item d-flex justify-content-between align-items-center <% if (todo.getComppleted()) { %>completed<% } %>">
                    <div>
                        <span class="fw-bold"><%= todo.getId() %></span> - <%= todo.getText() %>
                    </div>
                    <div>
                        <input type="checkbox" <%= todo.getComppleted() ? "checked" : "" %>
                               onchange="location.href='/javaweb/todolist/update?id=<%= todo.getId() %>&checked=' + this.checked;" />
                        已完成
                        <a href="/javaweb/todolist/delete?id=<%= todo.getId() %>"
                           style="display: <%= todo.getComppleted() ? "none" : "" %>" 
                           class="btn btn-danger btn-sm ms-2">刪除</a>
                    </div>
                </li>
            <% } %>
        </ul>
    </div>

    <!-- 引入 Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
