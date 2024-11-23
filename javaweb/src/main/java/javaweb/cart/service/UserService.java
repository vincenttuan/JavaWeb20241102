package javaweb.cart.service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class UserService {
	
	// 產生鹽
	private String generateSalt() {
		// 數學上安全不可預測的偽隨機(安全的亂數)
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		// 將 byte[] 透過 Base64 編碼並轉成 String
		// 方便儲存在資料表中
		return Base64.getEncoder().encodeToString(salt); 
	}
	
	// 雜湊加鹽加密
	// 放入 password 與 salt 可以得到加鹽後的雜湊碼
	private static String getHashPassword(String password, String salt) {
		try {
			// 加密演算法: SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt.getBytes()); // 先放鹽
			byte[] bytes = md.digest(password.getBytes()); // 再進行加密
			// 將 byte[] 透過 Base64 編碼並轉成 String
			// 方便儲存在資料表中
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
