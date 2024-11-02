package javaweb.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** 
 * 找零錢程式 II (透過 stream 來實現)
 * 使用者輸入零錢 change=87
 * 網址: /exchange?change=87
 * 輸出: 找零錢 87 元
 * 		 50元 1 個
 * 		 10元 3 個
 * 		  5元 1 個
 * 		  1元 2 個
 */

@WebServlet("/exchange2")
public class ExchangeServlet2 extends HttpServlet {
	int change = 0;
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
		
		change = Integer.parseInt(changeStr); // 字串轉 int
		resp.getWriter().println("找零錢 " + change + " 元");
		
		// ----------------------------------------------------------
		
		// 定義面額
		List<Integer> denoms = List.of(50,  10,  5, 1);
		
		// {50=1, 10=3, 5=1, 1=2}
		Map<Integer, Integer> result = denoms.stream().collect(
					Collectors.toMap(denom -> denom, 
									 denom -> {
										 int count = change / denom;
										 change = change % denom;
										 return count;
									 })
				);
		
		resp.getWriter().println(result);
		
	}
	
}
