package proxy_dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

// 實現動態代理
public class DynProxy {
	
	// 被代理的對象
	private Object object; // 可以代理任何物件
	
	public DynProxy(Object proxy) { // 注入被代理的物件
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
		InvocationHandler handler = null;
		
		// 得到代理物件
		proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
