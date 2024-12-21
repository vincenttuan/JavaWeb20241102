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

@WebServlet("/product/cart")
public class ProductCartServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 session 中的 cart 資料
		HttpSession session = req.getSession();
		
		// 查看是否有無購物車資料
		if(session.getAttribute("cart") == null) {
			// 重導到 result.jsp 頁面
			req.setAttribute("resultTitle", "購物車");
			req.setAttribute("resultMessage", "購物車無任何商品資料 !");
			req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
			return;
		}
		
		// 重導到 cart.jsp 頁面 
		req.getRequestDispatcher("/WEB-INF/view/cart/cart.jsp").forward(req, resp);
		
		
	}
	
	
	
}
