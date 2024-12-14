package javaweb.cart.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import javaweb.cart.service.ProductService;
import javaweb.cart.service.impl.ProductServiceImpl;

@WebServlet("/product/add")
@MultipartConfig(maxFileSize = 1024*1024*10) // 設定圖片上傳大小 10M
public class ProductAddServlet extends HttpServlet {
	
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收表單資料
		String productName = req.getParameter("productName");
		String price = req.getParameter("price");
		String qty = req.getParameter("qty");
		
		// 接收上傳檔案資料
		Part productImage = req.getPart("productImage");
		// 將 productImage 轉 byte[]
		byte[] bytes = productImage.getInputStream().readAllBytes();
		// 將 bytes[] 轉 base64 字串方便儲存在資料庫中
		String productImageBase64 = Base64.getEncoder().encodeToString(bytes);
		
		// 儲存
		productService.add(productName, price, qty, productImageBase64);
		
		// 重導到 result.jsp 頁面
		req.setAttribute("resultTitle", "商品新增");
		req.setAttribute("resultMessage", productName + " 商品新增成功<p><img src='data:image/png;base64," + productImageBase64 + "'>");
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
		
		
		// -----------------------------------------------------------------------------------
		// 儲存檔案(僅為 demo 用, 本專案不用此方式)
		//Files.write(Paths.get("C:/temp/demo.png"), bytes, StandardOpenOption.CREATE_NEW);
		
		// 顯示傳上來的資訊
		/*
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print("上傳資料如下:<p>");
		resp.getWriter().print("productName:" + productName + "<p>");
		resp.getWriter().print("price:" + price + "<p>");
		resp.getWriter().print("qty:" + qty + "<p>");
		resp.getWriter().print("productImageBase64:" + productImageBase64 + "<p>");
		resp.getWriter().print("<img src='data:image/png;base64," + productImageBase64 + "'>");
		*/
	}
	
	
}
