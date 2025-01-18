package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		// 載入配置資訊 AppConfig
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// 取得 Calculator 物件(Bean)
		System.out.println("Calculator:");
		Calculator calculator = context.getBean(Calculator.class);
		System.out.println(calculator.div(30, 10));
		System.out.println(calculator.div(30, 0));
		
		
	}
}
