package proxy_dyn;

import java.lang.reflect.Method;
import java.util.Arrays;

// Aspect 切面程式 
// 紀錄方法前後所要做的事
public class MyPrintAspect {
	
	// before: 前置通知 (Advice)
	public static void before(Method method, Object[] args) {
		// 代理執行任務(公用邏輯)
		System.out.printf("方法呼叫前-方法啟動: %s 參數: %s\n", method.getName(), Arrays.toString(args));
		
	}
	
	// exception: 例外通知 (Advice)
	public static void exception(Exception e) {
		System.out.println("發生例外錯誤: " + e);
	}
	
	// end: 後置通知 (Advice)
	public static void end() {
		// 代理執行任務(公用邏輯)
		System.out.println("方法呼叫後-方法結束");
	}
	
}
