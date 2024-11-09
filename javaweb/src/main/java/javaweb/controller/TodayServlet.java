package javaweb.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/today") // 定義 servlet path
public class TodayServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 告知瀏覽器你的網頁編碼資訊
		// 設定回應編碼(UTF-8)
		resp.setCharacterEncoding("UTF-8");
		// 設定回應文件格式(text/plain;charset=UTF-8)
		resp.setContentType("text/plain;charset=UTF-8");
		
		Date today = new Date();
		/**
		 * 格式說明
		 * yyyy => 西元, MM => 月, dd => 日, HH => (時(24H)), hh => (時(12H)), mm => 分, ss => 秒
		 * a => 上下午(am/pm)
		 * */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		
		// 資料印出
		System.out.println(sdf.format(today)); // 顯示伺服端在下方 Console 主控台
		
		resp.getWriter().println(sdf.format(today)); // 顯示在客戶端瀏覽器上
	}
	
	
}