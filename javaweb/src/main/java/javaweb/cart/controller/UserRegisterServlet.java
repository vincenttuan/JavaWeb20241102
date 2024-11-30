package javaweb.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.cart.service.EmailService;
import javaweb.cart.service.UserRegisterService;
import javaweb.cart.service.impl.UserRegisterServiceImpl;

@WebServlet("/user/register")
public class UserRegisterServlet extends HttpServlet {
	
	private UserRegisterService userRegisterService = new UserRegisterServiceImpl();
	
	private EmailService emailService = new EmailService();
	
	// 透過網址進行 GET 請求要做的事
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// RequestDispatcher 分派器
		// forward // 向前行 GO~~~
		req.getRequestDispatcher("/WEB-INF/view/cart/user_register.jsp").forward(req, resp);
	}
	
	// 透過表單進行 POST 請求要做的事
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 接收到表單傳來的資料
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		// 2. 將資料傳給 service 進行新增資料程序(資料庫新增一筆資料)
		userRegisterService.addUser(username, password, email);
		resp.getWriter().println("Add OK");
		resp.getWriter().flush();
		
		// 3. 發送 email 給新註冊的用戶(發送確認信給新註冊的用戶)
		emailService.sendEmail(email, "http://localhost:8080/javaweb/cart/email/confirm?username=" + username);
		resp.getWriter().println("Email send OK");
		
	}
	
}
