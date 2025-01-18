package proxy_dyn;

public class Test3 {
	public static void main(String[] args) {
		// 透過動態代理寫法
		DynProxy dynProxy = new DynProxy(new CalcImpl());
		Calc calc = (Calc)dynProxy.getProxy();
		System.out.println(calc.add(20, 10));
		System.out.println(calc.div(55, 5));
		System.out.println(calc.div(10, 0)); // 故意造成錯誤
		
		
	}
}
