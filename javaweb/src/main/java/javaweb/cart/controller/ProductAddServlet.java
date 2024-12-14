package javaweb.cart.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/product/add")
@MultipartConfig(maxFileSize = 1024*1024*10) // 設定圖片上傳大小 10m
public class ProductAddServlet extends HttpServlet {
	
}
