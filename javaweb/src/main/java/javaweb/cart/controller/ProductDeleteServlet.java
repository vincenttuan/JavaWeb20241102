package javaweb.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.cart.service.ProductService;
import javaweb.cart.service.impl.ProductServiceImpl;

@WebServlet("/product/delete")
public class ProductDeleteServlet extends HttpServlet {
	
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer productId = Integer.parseInt(req.getParameter("productId"));
		productService.delete(productId);
		
		// 重跑商品管理頁
		resp.sendRedirect("/javaweb/product/list");
	}
	
}
