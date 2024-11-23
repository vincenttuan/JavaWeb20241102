package javaweb;

import java.util.Scanner;
import static javaweb.cart.service.UserService.generateSalt;
import static javaweb.cart.service.UserService.getHashPassword;

public class TestHashCode {
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
		if(myHashPassword.equals(hashPassword)) {
			System.out.println("登入成功");
		} else {
			System.out.println("登入失敗");
		}
		
	}
}
