package javaweb.cart.controller;

import java.io.IOException;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/product/add")
@MultipartConfig(maxFileSize = 1024*1024*10) // 設定圖片上傳大小 10m
public class ProductAddServlet extends HttpServlet {

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
		
		// 顯示傳上來的資訊
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print("上傳資料如下:<p>");
		resp.getWriter().print("productName:" + productName + "<p>");
		resp.getWriter().print("price:" + price + "<p>");
		resp.getWriter().print("qty:" + qty + "<p>");
		resp.getWriter().print("productImageBase64:" + productImageBase64 + "<p>");
		resp.getWriter().print("<img src='data:image/png;base64," + productImageBase64 + "'>");
		
		
	}
	
	
}
