package javaweb.controller;

import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lotto/*") // 設定 servlet path
public class LottoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random random = new Random();
		Set<Integer> lottos = new TreeSet();
		// 今彩 539: 1~39 選 5 個不重複的數字
		while (lottos.size() < 5) {
			lottos.add(random.nextInt(39) + 1); // 0~38 + 1
		}
		// Console 輸出
		System.out.println(lottos);
		
		// 網頁資料輸出
		resp.getWriter().println(lottos);
		// 各種 Path 說明
		resp.getWriter().println("context path: " + req.getContextPath());
		resp.getWriter().println("servlet path: " + req.getServletPath());
		resp.getWriter().println("info path: " + req.getPathInfo());
	}
	
}
