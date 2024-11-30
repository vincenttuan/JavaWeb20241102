package javaweb.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.cart.service.UserRegisterService;
import javaweb.cart.service.impl.UserRegisterServiceImpl;

@WebServlet("/cart/email/confirm")
public class EmailConfirmServlet extends HttpServlet {
	
	private UserRegisterService userRegisterService = new UserRegisterServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;chatset=utf-8");
		
		// 得到 username
		String username = req.getParameter("username");
		
		// email 驗證成功 (修改 user 資料表中 completed 欄位的資訊) 重要 !!
		userRegisterService.emailConfirmOK(username);
		
		resp.getWriter().print("<h1>User name = " + username + " email 驗證成功</h1>");
		
	}
	
}
