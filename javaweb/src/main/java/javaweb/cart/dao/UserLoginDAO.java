package javaweb.cart.dao;

import javaweb.cart.model.entity.User;

public interface UserLoginDAO {
	
	User findUserByName(String username);
	
}
