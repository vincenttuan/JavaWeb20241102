package proxy_dyn;

import java.lang.reflect.Method;
import java.util.Arrays;

// Aspect
// 紀錄方法前後所要做的事
public class MyPrintAspect {
	
	// 代理執行任務(公用邏輯)
	public static void before(Method method, Object[] args) {
		// 代理執行任務(公用邏輯)
		System.out.printf("方法呼叫前-方法啟動: %s 參數: %s\n", method.getName(), Arrays.toString(args));
		
	}
	
	// 代理執行任務(公用邏輯)
	public static void end() {
		// 代理執行任務(公用邏輯)
		System.out.println("方法呼叫後-方法結束");
	}
	
}
