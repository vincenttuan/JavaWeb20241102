package javaweb.cart.service;

import java.util.List;

import javaweb.cart.model.dto.UserDTO;

public interface UserListService {
	List<UserDTO> findAllUsers();
}
