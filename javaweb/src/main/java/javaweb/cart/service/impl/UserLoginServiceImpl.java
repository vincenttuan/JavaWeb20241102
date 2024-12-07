package javaweb.cart.service.impl;

import javaweb.cart.dao.UserLoginDAO;
import javaweb.cart.dao.impl.UserLoginDAOImpl;
import javaweb.cart.model.entity.User;
import javaweb.cart.service.UserLoginService;
import javaweb.cart.service.UserService;

public class UserLoginServiceImpl implements UserLoginService {
	
	private UserLoginDAO userLoginDAO = new UserLoginDAOImpl();
	
	@Override
	public boolean login(String username, String password, String authcode, String sessionAuthCode) {
		// 1. 比對驗證碼
		//if(!authcode.equals(sessionAuthCode)) { // 驗證碼不符
		if(!authcode.equalsIgnoreCase(sessionAuthCode)) { // 驗證碼不符
					throw new RuntimeException("驗證碼不符");
		}
		// 2.透過 username 尋找有無此使用者 ?
		User user = userLoginDAO.findUserByName(username);
		if(user == null) {
			throw new RuntimeException("查無使用者");
		}
		// 3.驗證 email 是否有確認通過 ?
		boolean completed = user.getCompleted();
		if(!completed) {
			throw new RuntimeException("此帳號 email 沒有驗證");
		}
		// 4.驗證密碼
		// 將 password + user.getHashSalt() 產生的 hash 是否與 user.getHashPassword() 中資料一致 ?
		String hashPassword = UserService.getHashPassword(password, user.getHashSalt()); // 待比對的 hashPassword
		boolean checkPassword = user.getHashPassword().equals(hashPassword); // 比對
		if(!checkPassword) {
			throw new RuntimeException("密碼錯誤");
		}
		return true;
	}

}
