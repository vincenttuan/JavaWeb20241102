package javaweb.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaweb.cart.model.dto.ProductDTO;
import javaweb.cart.service.ProductService;
import javaweb.cart.service.impl.ProductServiceImpl;

// 將商品加入到購物車
// 將所訂購的商品暫存在 session 中
@WebServlet("/product/order/add/cart")
public class ProductOrderAddCart extends HttpServlet {
	
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		List<ProductDTO> cart = null; // 購物車
		// 確認 session 中有無購物車物件資料
		if(session.getAttribute("cart") == null) {
			cart = new ArrayList<>();
		} else {
			cart = (List<ProductDTO>)session.getAttribute("cart");
		}
		// ----------------------------------------------------------
		// 取得欲加入到購物車的 productId
		Integer productId = Integer.parseInt(req.getParameter("productId"));
		// 取得根據 productId 取得 ProductDTO
		Optional<ProductDTO> optProductDTO = productService.findAll()
									.stream()
									.filter(dto -> dto.getProductId().equals(productId))
									.findAny();
		// 若有找到 ProductDTO
		if(optProductDTO.isPresent()) {
			// 將 ProductDTO 加入到 cart 中
			cart.add(optProductDTO.get());
		}
		// 將 cart 資料回存到 session
		session.setAttribute("cart", cart);
		
		// 回到訂購商品主頁
		resp.sendRedirect("/javaweb/product/order");
		
		// 重導到 result.jsp 頁面
		//req.setAttribute("resultTitle", "訂購商品");
		//req.setAttribute("resultMessage", "目前購物車商品筆數: " + cart.size() + " 筆");
		//req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
				
	}
	
	
}
