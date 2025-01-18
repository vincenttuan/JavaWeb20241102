package proxy_dyn;

public class Test1 {
	public static void main(String[] args) {
		Calc calc = new CalcImpl();
		System.out.println(calc.add(20, 10));
		System.out.println(calc.div(20, 10));
		
	}
}
