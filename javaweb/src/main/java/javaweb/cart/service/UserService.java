package javaweb.cart.service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class UserService {
	
	public static void main(String[] args) {
		String password = "1234"; // 密碼
		String hashSalt = generateSalt(); // 鹽
		String hashPassword = getHashPassword(password, hashSalt);
		System.out.println("密碼:" + password);
		System.out.println("hashSalt:" + hashSalt);
		System.out.println("hashPassword:" + hashPassword);
		
		// 比對
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入 password: ");
		String userPassword = scanner.next();
		// 根據我輸入的密碼與原本已經儲存的鹽來產生新的雜湊密碼
		String myHashPassword = getHashPassword(userPassword, hashSalt);
		// 將新的雜湊密碼與原本的雜湊密碼進行比對
		if(myHashPassword.equals(myHashPassword)) {
			System.out.println("登入成功");
		} else {
			System.out.println("登入失敗");
		}
		
	}
	
	// 產生鹽
	private static String generateSalt() {
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
