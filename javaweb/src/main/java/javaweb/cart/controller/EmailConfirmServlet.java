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
		
		// 準備要傳遞給 result.jsp 的資訊
		String resultTitle = "Email驗證結果";
		String resultMessage = "用戶名稱: " + username + "<p />Email 驗證成功";
		req.setAttribute("resultTitle", resultTitle);
		req.setAttribute("resultMessage", resultMessage);
		
		// 重導到 result.jsp
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
		
	}
	
}
