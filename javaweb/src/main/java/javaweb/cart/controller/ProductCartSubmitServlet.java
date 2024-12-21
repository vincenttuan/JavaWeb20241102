package javaweb.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.cart.service.OrderService;
import javaweb.cart.service.impl.OrderServiceImpl;

// 購物車資料結帳
@WebServlet("/product/cart/submit")
public class ProductCartSubmitServlet extends HttpServlet {
	
	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 從 session 中取得 userId 與 cart 資訊
		
		
	}
	
}
