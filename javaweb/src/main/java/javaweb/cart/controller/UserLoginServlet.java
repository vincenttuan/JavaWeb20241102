package javaweb.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.cart.service.UserLoginService;
import javaweb.cart.service.impl.UserLoginServiceImpl;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	
	private UserLoginService userLoginService = new UserLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/cart/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String authcode = req.getParameter("authcode");
		
		// 驗證帳號與密碼
		String resultTitle = "登入結果";
		String resultMessage = "";
		try {
			boolean checkLogin = userLoginService.login(username, password); // 進行驗證並取得結果
			if(checkLogin) { // 驗證成功
				resultMessage = username + " 登入成功";
			}
		} catch (RuntimeException e) { // 驗證失敗
			resultMessage = e.getMessage(); // 失敗原因
		}
		
		// 給 result.jsp 的資訊
		req.setAttribute("resultTitle", resultTitle);
		req.setAttribute("resultMessage", resultMessage);
		
		// 重導到 result.jsp
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
		
	}
	
	
	
}
