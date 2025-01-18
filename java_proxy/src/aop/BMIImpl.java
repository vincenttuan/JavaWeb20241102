package aop;

public class BMIImpl implements BMI {
	public static int count = 0; 
	@Override
	public double calc(double h, double w) {
		double bmi = w / Math.pow(h/100, 2);
		return bmi;
	}

}
