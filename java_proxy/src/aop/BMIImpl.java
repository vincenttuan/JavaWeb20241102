package aop;

public class BMIImpl implements BMI {

	@Override
	public double calc(double h, double w) {
		return w / Math.pow(h/100, 2);
	}

}
