package javaweb.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** 
 * 找零錢程式
 * 使用者輸入零錢 change=87
 * 網址: /exchange?change=87
 * 輸出: 找零錢 87 元
 * 		 50元 1 個
 * 		 10元 3 個
 * 		  5元 1 個
 * 		  1元 2 個
 */

@WebServlet("/exchange")
public class ExchangeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String changeStr = req.getParameter("change");
		if(changeStr == null) {
			resp.getWriter().println("請輸入零錢 change=?");
			return;
		}
		int change = Integer.parseInt(changeStr); // 字串轉 int
		resp.getWriter().println("找零錢 " + change + " 元");
	}
	
}
