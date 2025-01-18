package proxy_dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// 實現動態代理
public class DynProxy {
	
	// 被代理的對象
	private Object object; // 可以代理任何物件
	
	public DynProxy(Object object) { // 注入被代理的物件
		this.object = object;
	}
	
	// 取得代理物件
	public Object getProxy() {
		Object proxyObj = null;
		// 1. loader 載入類別器
		ClassLoader loader = object.getClass().getClassLoader();
		// 2. 被代理的物件所實現的介面(接口)
		Class<?>[] interfaces = object.getClass().getInterfaces();
		// 3. 處理代理的實現
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// 代理執行任務(公用邏輯)
				System.out.printf("方法呼叫前-方法啟動: %s 參數: %s %d\n", method.getName(), Arrays.toString(args));
				// 代理執行任務(業務邏輯)
				Object result = method.invoke(object, args); // 執行被代理的任務方法(固定寫法)
				// 代理執行任務(公用邏輯)
				System.out.println("方法呼叫後-方法結束");
				return result; // (固定寫法)
			}
		};
		
		// 得到代理物件
		proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
