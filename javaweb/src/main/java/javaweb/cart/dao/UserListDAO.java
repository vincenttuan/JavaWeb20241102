package javaweb.cart.dao;

import java.util.List;

import javaweb.cart.model.entity.User;

public interface UserListDAO {
	
	// 查詢所有使用者
	List<User> findAllUsers();
	
}
