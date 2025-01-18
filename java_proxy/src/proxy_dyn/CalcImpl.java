package proxy_dyn;

public class CalcImpl implements Calc {

	@Override
	public int add(int x, int y) {
		// 公用邏輯(觀察 x, y 的值);
		System.out.printf("觀察 x: %d, y:%d%n", x, y);
		// 業務邏輯
		int result = x + y;
		return result;
	}

	@Override
	public int div(int x, int y) {
		// 公用邏輯(觀察 x, y 的值);
		System.out.printf("觀察 x: %d, y:%d%n", x, y);
		// 業務邏輯
		int result = x / y;
		return result;
	}

}
