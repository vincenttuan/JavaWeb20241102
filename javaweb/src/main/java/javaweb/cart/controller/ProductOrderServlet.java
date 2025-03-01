package javaweb.cart.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.cart.model.dto.ProductDTO;
import javaweb.cart.service.ProductService;
import javaweb.cart.service.impl.ProductServiceImpl;

@WebServlet("/product/order")
public class ProductOrderServlet extends HttpServlet {
	
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得所有商品
		List<ProductDTO> productDTOs = productService.findAll();
		req.setAttribute("productDTOs", productDTOs);
		// 重導到商品訂單頁面
		req.getRequestDispatcher("/WEB-INF/view/cart/product_order_list.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
