package javaweb.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.model.dao.TodoListDao;
import javaweb.model.dao.impl.TodoListDaoInMempry;
import javaweb.model.dao.impl.TodoListDaoMySQL;
import javaweb.model.entity.Todo;

@WebServlet("/todolist/*")
public class TodoListServlet extends HttpServlet {
	
	//private TodoListDao todoListDao = new TodoListDaoInMempry();
	private TodoListDao todoListDao = new TodoListDaoMySQL();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String id = req.getParameter("id");
		String checked = req.getParameter("checked");
		
		switch (pathInfo) {
			case "/update": // 修改 
				Boolean complete = Boolean.valueOf(checked); // String 轉 Boolean
				todoListDao.updateTodoComplete(Integer.parseInt(id), complete);
				// 修改完之後要去的地方
				resp.sendRedirect("/javaweb/todolist/");
				return;
			case "/update/text":
				// 中文要解碼
				// 因為 GET 在傳遞中文會自動進行 URL 編碼(例如: 看報表 => %E7%9C%8B%E5%A0%B1%E8%A1%A8)
				
				// http://localhost:8080/javaweb/update/text?id=1&text=看報紙
				// 實際傳遞
				// http://localhost:8080/javaweb/update/text?id=1&text=%E7%9C%8B%E5%A0%B1%E8%A1%A8
				
				// 將 %E7%9C%8B%E5%A0%B1%E8%A1%A8 解碼還原成 "看報紙"
				String text = URLDecoder.decode(req.getParameter("text"), "UTF-8");
				todoListDao.updateTodoText(Integer.parseInt(id), text);
				// 修改完之後要去的地方
				resp.sendRedirect("/javaweb/todolist/");
				return;
			case "/delete": // 刪除
				todoListDao.deleteTodo(Integer.parseInt(id));
				// 刪除完之後要去的地方
				resp.sendRedirect("/javaweb/todolist/");
				return;
			default: // 其他
				
		}
		
		List<Todo> todos = todoListDao.findAllTodos();
		req.setAttribute("todos", todos);
		req.getRequestDispatcher("/WEB-INF/view/todolist.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(!pathInfo.equals("/add")) {
			return;
		}
		
		String id = req.getParameter("id");
		String text = req.getParameter("text");
		
		// 建立 todo 物件
		Todo todo = new Todo();
		todo.setId(Integer.parseInt(id));
		todo.setText(text);
		todo.setCompleted(false);
		
		// 新增
		todoListDao.addTodo(todo);
		
		// 自動轉跳到 /javaweb/todolist/ 頁
		//resp.sendRedirect("http://localhost:8080/javaweb/todolist/");
		resp.sendRedirect("/javaweb/todolist/");
	}
	
	
	
}
