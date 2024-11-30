package javaweb.cart.dao;

import javaweb.cart.model.entity.User;

// 定義對 user 資料表進行 CRUD 的功能
public interface UserRegisterDAO {
	// 新增 user
	int addUser(User user);
	
	// email 驗證成功並修改 completed = true
	int emailConfirmOK(String username);
}
