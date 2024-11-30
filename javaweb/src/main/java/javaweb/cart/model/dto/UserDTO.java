package javaweb.cart.model.dto;

import lombok.Data;

@Data
public class UserDTO { // 前端需要/可用的資料欄位
	private Integer id;
	private String username;
	private String email;
	private Boolean completed;
}
