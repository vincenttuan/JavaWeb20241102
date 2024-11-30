package javaweb.cart.dao;

import java.util.List;

import javaweb.cart.model.entity.User;

public interface UserListDAO {
	
	List<User> findAllUsers();
	
}
