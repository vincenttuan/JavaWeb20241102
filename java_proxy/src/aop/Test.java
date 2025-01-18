package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		// 載入配置資訊 AppConfig
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// 取得 Calculator 物件(Bean)
		Calculator calculator = context.getBean(Calculator.class);
		System.out.println(calculator.add(30, 10));
		System.out.println(calculator.sub(30, 10));
		System.out.println(calculator.mul(30, 10));
		System.out.println(calculator.div(30, 10));
		
	}
}
