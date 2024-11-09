package javaweb.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 抽獎程式
 * 號碼  獎項
 * 1   : 現金10萬元
 * 2   : 禮券2萬元
 * 3   : 禮券5000元
 * 4   : 現金500元
 * 5~10: 7-11 100元
 * ----------------
 * 您抽到 ___ 號 獎項: ____
 * */

@WebServlet("/lottery")
public class LotteryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 編碼 UTF-8
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
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
		
		// 顯示資料(瀏覽器)
		String html = """
				<html>
					<head>
						<meta charset="UTF-8">
						<title>Index</title>
					</head>
					<body>
						獎品列表
						<table border="1">
							<thead>
								<tr>
									<th>獎號</th><th>獎項</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>%d</td><td>%s</td>
									<td>%d</td><td>%s</td>
									<td>%d</td><td>%s</td>
									<td>%d</td><td>%s</td>
									<td>%d</td><td>%s</td>
								</tr>
							</tbody>
						</table>
						<p />
						您抽到 %d 號 獎項: %s
					</body>
				</html>
				""";
		resp.getWriter().println(html);
	}
	
}
