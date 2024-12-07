package javaweb.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/logout")
public class UserLogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// 將 session 失效
		session.invalidate();
		
		// 給 result.jsp 的資訊
		String resultTitle = "使用者登出";
		String resultMessage = "使用者登出成功";
		
		req.setAttribute("resultTitle", resultTitle);
		req.setAttribute("resultMessage", resultMessage);
		
		// 重導到 result.jsp
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
		
	}
	
}
