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
		// 監聽 username 加入到 session 中, 表示有人登入了
		HttpSession session = se.getSession();
		if(session.getAttribute("username") != null) {
			String username = session.getAttribute("username") + "";
			System.out.println("有人登入了, username = " + username);
			loginCount++;
		}
	}
	
	// Session 失效監聽
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		if(session.getAttribute("username") != null) {
			String username = session.getAttribute("username") + "";
			System.out.println("有人登出了, username = " + username);
			loginCount--;
		}
	}
	
}
