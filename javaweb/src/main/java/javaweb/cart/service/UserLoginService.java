package javaweb.cart.service;

import javaweb.cart.model.entity.User;

public interface UserLoginService {
	// 驗證登入是否成功 ?
	User login(String username, String password, String authcode, String sessionAuthCode);
}
