package javaweb;

import javaweb.cart.service.EmailService;

public class TestEmail {
	// 測試主程式 (Run As -> Java Application)
	public static void main(String[] args) {
		new EmailService().sendEmail("vincenttuan@gmail.com", "http://localhost:8080/javaweb/cart/email/confirm?id=1");
	}
}
