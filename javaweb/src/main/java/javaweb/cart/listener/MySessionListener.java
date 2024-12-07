package javaweb.cart.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

// 監聽 session 的創建與使用
@WebListener
public class MySessionListener implements HttpSessionListener {
	public static int loginCount = 0;
	// Session 創建監聽
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		loginCount++;
		System.out.println("目前人數: " + loginCount);
	}
	
	// Session 失效監聽
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		loginCount--;
		System.out.println("目前人數: " + loginCount);
	}
	
}
