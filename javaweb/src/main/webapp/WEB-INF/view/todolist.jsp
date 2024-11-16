<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>My Todo List</title>
	<!-- 引入 Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
		<li>
			1 - Task 1 <input type="checkbox" /> <button type="button">刪除</button>
		</li>
		<li>
			2 - Task 2 <input type="checkbox" checked /> <button type="button">刪除</button>
		</li>
		<li>
			3 - Task 3 <input type="checkbox" /> <button type="button">刪除</button>
		</li>
	</ul>
	
	<!-- 引入 Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>