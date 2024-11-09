package javaweb.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

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
	
	private Random random = new Random();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 開始抽獎
		// 獎號
		String myId = String.valueOf(random.nextInt(awards.length) + 1);  
		// 獎項
		String[] myAward = Stream.of(awards)
							.filter(award->award[0].equals(myId))
							.findAny()
							.orElseGet(null);
		// 獎項名字
		String myAwardName = myAward[1];
		// 獎項庫存
		int myAwardQty = Integer.parseInt(myAward[2]);
		if(myAwardQty > 0) {
			// 更新獎項庫存 -1
			myAward[2] = String.valueOf(Integer.parseInt(myAward[2]) - 1);
		} else {
			myAwardName += "已經售完";
		}
		
		System.out.println("獎號 myId: " + myId);
		System.out.println("獎項 myAward: " + Arrays.toString(myAward));
		System.out.println("獎項名字 myAwardName: " + myAwardName);
		System.out.println("獎項庫存 myAwardQty: " + myAward[2]);
		
		
		req.setAttribute("awards", awards);
		// 指向到 jsp
		req.getRequestDispatcher("/WEB-INF/view/capsule.jsp").forward(req, resp);
	}
	
}
