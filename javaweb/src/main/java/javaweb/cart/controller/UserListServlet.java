package javaweb.cart.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.cart.model.dto.UserDTO;
import javaweb.cart.service.UserListService;
import javaweb.cart.service.impl.UserListServiceImpl;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {
	
	private UserListService userListService = new UserListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 得到所有用戶資料
		List<UserDTO> userDTOs = userListService.findAllUsers();
		// 將 userDTOs 透過 req.setAttribute() 將資料儲存, 目的: 給 jsp 渲染網頁使用
		req.setAttribute("userDTOs", userDTOs); // (資料名稱, 資料內容)
		// 重導到指定 jsp 頁面
		req.getRequestDispatcher("/WEB-INF/view/cart/user_list.jsp").forward(req, resp);
	}
	
}
