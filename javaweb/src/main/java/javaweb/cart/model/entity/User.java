package javaweb.cart.model.entity;

import lombok.Data;

// 對應資料表 user 的欄位
@Data
public class User {
	private Integer id;
	private String username;
	private String hashPassword;
	private String hashSalt;
	private String email;
	private Boolean completed;
}
