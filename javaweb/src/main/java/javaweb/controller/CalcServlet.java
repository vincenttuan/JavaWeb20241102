package javaweb.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 四則運算網路服務
 * 
 * 網址: /calc/add?x=20&y=10 得到 30
 * 網址: /calc/sub?x=20&y=10 得到 10
 * 網址: /calc/mul?x=20&y=10 得到 200
 * 網址: /calc/div?x=20&y=10 得到 2
 * 
 * */

@WebServlet("/calc/*")
public class CalcServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// UTF-8 編碼
		req.setCharacterEncoding("UTF-8");  // 請求編碼
		resp.setCharacterEncoding("UTF-8"); // 回應編碼
		resp.setContentType("text/plain;charset=UTF-8"); // 文件編碼
		
		// 透過 req.getParameter("x") 取得 x 與 req.getParameter("y") 取得 y 的參數
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		
		resp.getWriter().println("x = " + x);
		resp.getWriter().println("y = " + y);
		
		// 判斷 x, y 是否有輸入 ?
		if(x == null || y == null) {
			resp.getWriter().println("請輸入 x, y 參數");
			return;
		}
		
		String pathInfo = req.getPathInfo();
		
		switch (pathInfo) {
			case "/add":
				// 加法
				int addResult = Integer.parseInt(x) + Integer.parseInt(y);
				resp.getWriter().println("addResult = " + addResult);
				break;
			case "/sub":
				int subResult = Integer.parseInt(x) - Integer.parseInt(y);
				resp.getWriter().println("subResult = " + subResult);
				break;
			case "/mul":
				int mulResult = Integer.parseInt(x) * Integer.parseInt(y);
				resp.getWriter().println("mulResult = " + mulResult);
				break;
			case "/div":
				int divResult = Integer.parseInt(x) / Integer.parseInt(y);
				resp.getWriter().println("divResult = " + divResult);
				break;	
		}
		
	}
	
}
