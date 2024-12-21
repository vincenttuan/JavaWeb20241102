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

// 刪除購物車內容
@WebServlet("/product/cart/delete")
public class ProductCartDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int index = Integer.parseInt(req.getParameter("index"));
		
		HttpSession session = req.getSession();
		List<ProductDTO> cart = (List<ProductDTO>)session.getAttribute("cart"); // 取得購物車目前資料
		cart.remove(index); // 移除
		
		// 若購物車無資料, 則將 seesion 中的 cart 資料移除
		if(cart.size() == 0) {
			session.removeAttribute("cart");
		}
		
		// 重導到 cart.jsp 頁面 
		req.getRequestDispatcher("/WEB-INF/view/cart/cart.jsp").forward(req, resp);
	}
	
}
