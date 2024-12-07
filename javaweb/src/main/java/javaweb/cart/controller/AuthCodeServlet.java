package javaweb.cart.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 驗證碼圖片產出
@WebServlet("/user/authcode")
public class AuthCodeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 產生四位數的隨機驗證碼(位數不足要補 0, Ex: 0123)
		
		
		// 2. 將認證碼存放到 session 中以便其他程式進行比對
		
		
		// 3. 將認證碼以圖片形式送出
		
	}
	
	// 產生動態圖像
	private BufferedImage getAuthCodeImage(String authcode) {
		// 建立圖像區域 (80(寬度)x30(高度) RGB)
		BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		
		return img;
	}
	
}
