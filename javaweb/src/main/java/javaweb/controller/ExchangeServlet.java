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
		// UTF-8 編碼
		req.setCharacterEncoding("UTF-8");  // 請求編碼
		resp.setCharacterEncoding("UTF-8"); // 回應編碼
		resp.setContentType("text/plain;charset=UTF-8"); // 文件編碼
				
		String changeStr = req.getParameter("change");
		if(changeStr == null) {
			resp.getWriter().println("請輸入零錢 change=?");
			return;
		}
		int change = Integer.parseInt(changeStr); // 字串轉 int
		resp.getWriter().println("找零錢 " + change + " 元");
		
		int fifty = change / 50; // fifty = 1
		change %= 50;            // change = 37,  change = change % 50;
		
		int ten = change / 10;   // ten = 3
		change %= 10;            // change = 7
		
		int five = change / 5;   // five = 1
		int one = change %= 5;   // one = 2
		
		resp.getWriter().println("50元 " + fifty + " 個");
		resp.getWriter().println("10元 " + ten + " 個");
		resp.getWriter().println("5元 " + five + " 個");
		resp.getWriter().println("1元 " + one + " 個");
		
	}
	
}
