package javaweb.cart.dao;

import java.util.List;

import org.apache.catalina.User;

// 定義對 user 資料表進行 CRUD 的功能
public interface UserRegisterDAO {
	// 查詢所有 user
	List<User> findAllUsers();
	
	// 查詢指定 user (根據 id 來找到該名 user)
	User getUserById(Integer id);
	
	// 查詢指定 user (根據 username 來找到該名 user)
	User getUserByName(String username);
		
	// 新增 user
	int addUser(User user);
	
	// 修改 password
	int updatePasswordById(Integer id, String newPassword);
	
}