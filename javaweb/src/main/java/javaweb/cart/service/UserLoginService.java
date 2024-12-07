package javaweb.cart.service;

public interface UserLoginService {
	// 驗證登入是否成功 ?
	boolean login(String username, String password);
}
