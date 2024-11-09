package javaweb.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lottery2")
public class Lottery2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 準備獎項
		Map<Integer, String> awards = Map.of(1, "現金10萬元", 2, "禮券2萬元", 3, "禮券5000元", 
				4, "現金500元", 5, "7-11 100元");
		
		// 抽號碼
		Random random = new Random(); // 隨機數
		Integer number = random.nextInt(10) + 1; // 0~9 + 1 => 1..10 的隨機數
		
		// 獎項
		String award = null;
		switch (number) {
			case 1:
			case 2:
			case 3:
			case 4:
				award = awards.get(number);
				break;
			default:
				award = awards.get(5);
		}
		
		// 顯示資料(console)
		System.out.printf("您抽到 %d 號 獎項: %s%n", number, award);
				
		// 透過 jsp 來顯示獎號(number)與獎項(award)
		// 設定要傳遞給 jsp 的資料
		req.setAttribute("number", number);
		req.setAttribute("award", award);
		// 透過分派器來forward往前傳(往 jsp 傳)
		req.getRequestDispatcher("/WEB-INF/view/lottery2.jsp").forward(req, resp);
		
	}
	
	
	
}
