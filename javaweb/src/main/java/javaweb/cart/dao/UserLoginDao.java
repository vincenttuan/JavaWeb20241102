package javaweb.cart.dao;

import javaweb.cart.model.entity.User;

public interface UserLoginDao {
	
	User findUserByName(String username);
	
}
