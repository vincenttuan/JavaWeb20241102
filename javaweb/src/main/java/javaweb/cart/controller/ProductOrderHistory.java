package javaweb.cart.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaweb.cart.model.dto.OrderDTO;
import javaweb.cart.service.OrderService;
import javaweb.cart.service.impl.OrderServiceImpl;

@WebServlet("/product/order/history")
public class ProductOrderHistory extends HttpServlet {
	
	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		// 得到使用者歷史訂單紀錄
		List<OrderDTO> orderDTOs = orderService.findAllOrdersByUserId(userId);
		req.setAttribute("orderDTOs", orderDTOs);
		
		req.getRequestDispatcher("/WEB-INF/view/cart/history.jsp").forward(req, resp);
		
	}
	
}
