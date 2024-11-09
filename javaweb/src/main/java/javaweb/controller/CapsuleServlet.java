package javaweb.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/capsule")
public class CapsuleServlet extends HttpServlet {
	private String[][] awards = {
			{"1", "小八貓", "5"},
			{"2", "烏薩奇", "5"},
			{"3", "吉伊卡哇", "5"},
			{"4", "小桃", "5"},
			{"5", "獅薩", "5"}
	};
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("awards", awards);
		// 指向到 jsp
		req.getRequestDispatcher("/WEB-INF/view/capsule.jsp").forward(req, resp);
	}
	
}
