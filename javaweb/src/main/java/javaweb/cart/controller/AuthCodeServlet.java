package javaweb.cart.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 驗證碼圖片產出
@WebServlet("/user/authcode")
public class AuthCodeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 產生四位數的隨機驗證碼(位數不足要補 0, Ex: 0123)
		Random random = new Random();
		String authcode = String.format("%04d", random.nextInt(10000)); // 0000~9999 隨機數
		System.out.println("認證碼: " + authcode);
		
		// 2. 將認證碼存放到 session 中以便其他程式進行比對
		HttpSession session = req.getSession();
		session.setAttribute("authcode", authcode);
		
		// 3. 將認證碼以圖片形式送出
		// resp.getWriter() 文字傳送
		// resp.getOutputStream() 非文字傳送
		ImageIO.write(getAuthCodeImage(authcode), "JPEG", resp.getOutputStream());
	}
	
	// 產生動態圖像
	private BufferedImage getAuthCodeImage(String authcode) {
		// 建立圖像區域 (80(寬度)x30(高度) RGB)
		BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		// 建立畫布
		Graphics g = img.getGraphics();
		// 設定顏色
		g.setColor(Color.YELLOW); // 拿起黃色的彩色筆
		// 塗滿背景
		g.fillRect(0, 0, 80, 30); // 全區域
		// 設定顏色
		g.setColor(Color.BLACK);
		// 設定字型
		g.setFont(new Font("Arial", Font.BOLD, 20)); // 字體, 風格, 大小
		// 繪文字
		g.drawString(authcode, 22, 22); // (22, 22) 表示繪文字左上角的起點
		
		return img;
	}
	
}
