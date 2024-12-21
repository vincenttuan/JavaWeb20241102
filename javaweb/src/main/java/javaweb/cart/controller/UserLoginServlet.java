package javaweb.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaweb.cart.model.entity.User;
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
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String authcode = req.getParameter("authcode");
		// 取得以存放在 session 的驗證碼(驗證碼圖片的內容)
		String sessionAuthcode = session.getAttribute("authcode") + "";
					
		// 驗證帳號與密碼
		String resultTitle = "登入結果";
		String resultMessage = "";
		try {
			User user = userLoginService.login(username, password, authcode, sessionAuthcode); // 進行驗證並取得結果
			boolean checkLogin = user != null;
			if(checkLogin) { // 驗證成功
				resultMessage = username + " 登入成功";
				
				// 將登入資訊存放到 session 變數中, session 變數可以"跨網頁"提取
				session.setAttribute("username", username);
				session.setAttribute("userId", user.getId());
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
