package proxy_dyn;

public class CalcImpl implements Calc {

	@Override
	public int add(int x, int y) {
		// 業務邏輯
		int result = x + y;
		return result;
	}

	@Override
	public int div(int x, int y) {
		// 業務邏輯
		int result = x / y;
		return result;
	}

}
