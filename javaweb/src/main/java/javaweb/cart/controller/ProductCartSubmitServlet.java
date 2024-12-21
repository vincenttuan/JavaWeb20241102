package javaweb.cart.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaweb.cart.model.dto.ProductDTO;
import javaweb.cart.service.OrderService;
import javaweb.cart.service.impl.OrderServiceImpl;

// 購物車資料結帳
@WebServlet("/product/cart/submit")
public class ProductCartSubmitServlet extends HttpServlet {
	
	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 從 session 中取得 userId 與 cart 資訊
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		List<ProductDTO> cart = (List<ProductDTO>)session.getAttribute("cart");
		
		orderService.addOrder(userId, cart);
		
		// 清空購物車
		//session.removeAttribute("cart");
		session.setAttribute("cart", null);
		
		// 重導到 result.jsp 頁面
		req.setAttribute("resultTitle", "購物車-結帳");
		req.setAttribute("resultMessage", "購物車結帳完畢");
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
		
	}
	
}
