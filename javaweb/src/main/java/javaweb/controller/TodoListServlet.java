package javaweb.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.model.dao.TodoListDao;
import javaweb.model.dao.impl.TodoListDaoInMempry;

@WebServlet("/todolist/*")
public class TodoListServlet extends HttpServlet {
	private TodoListDao todoListDao = new TodoListDaoInMempry();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		switch (pathInfo) {
			case "/update": // 修改 
				break;
			case "/delete": // 刪除
				break;
			default: // 其他
				
		}
		
		
		req.getRequestDispatcher("/WEB-INF/view/todolist.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
}
