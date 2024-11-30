package javaweb.cart.service.impl;

import java.util.List;

import javaweb.cart.dao.UserListDAO;
import javaweb.cart.dao.impl.UserListDaoImpl;
import javaweb.cart.model.dto.UserDTO;
import javaweb.cart.model.entity.User;
import javaweb.cart.service.UserListService;

public class UserListServiceImpl implements UserListService {
	private UserListDAO userListDAO = new UserListDaoImpl();
	@Override
	public List<UserDTO> findAllUsers() {
		// 1.從 userListDAO 取得 List<User>
		List<User> users = userListDAO.findAllUsers();
		
		// 2.將 List<User> 每一個元素由 User 轉成 UserDTO 使之變成 List<UserDTO>
		List<UserDTO> userDTOs = users.stream()
									  .map(user -> {
										  UserDTO userDTO = new UserDTO();
										  userDTO.setId(user.getId());
										  userDTO.setUsername(user.getUsername());
										  userDTO.setEmail(user.getEmail());
										  userDTO.setCompleted(user.getCompleted());
										  return userDTO;
									  })
									  .toList();
		
		return userDTOs;
	}
	
}
