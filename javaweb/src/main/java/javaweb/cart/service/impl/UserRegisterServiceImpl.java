package javaweb.cart.service.impl;

import javaweb.cart.dao.UserRegisterDAO;
import javaweb.cart.dao.impl.UserRegisterDAOImpl;
import javaweb.cart.model.entity.User;
import javaweb.cart.service.UserRegisterService;
import javaweb.cart.service.UserService;

public class UserRegisterServiceImpl implements UserRegisterService {
	
	// 取得 UserRegisterDAO 物件實體
	private UserRegisterDAO userRegisterDAO = new UserRegisterDAOImpl();
	
	@Override
	public void addUser(String username, String password, String email) {
		String hashSalt = UserService.generateSalt(); // 取得鹽
		String hashPassword = UserService.getHashPassword(password, hashSalt); // 將 password 與 salt 進行雜湊
		
		User user = new User(); // 建立 user 物件
		user.setUsername(username); // 注入 username
		user.setHashPassword(hashPassword); // 注入 hash password
		user.setHashSalt(hashSalt); // 注入 hash salt
		user.setEmail(email); // 注入 email
		
		// 新增 user
		userRegisterDAO.addUser(user);
	}

}
