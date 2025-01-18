package proxy_dyn;

public class Test2 {
	public static void main(String[] args) {
		// 原始寫法
		Calc calc = new CalcImpl();
		System.out.println(calc.add(20, 10));
		System.out.println(calc.div(55, 5));
		System.out.println();
		
		// 透過動態代理寫法
		DynProxy dynProxy = new DynProxy(new CalcImpl());
		calc = (Calc)dynProxy.getProxy();
		System.out.println(calc.add(20, 10));
		System.out.println(calc.div(55, 5));
		System.out.println();
		
	}
}
