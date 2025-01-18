package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
	public static void main(String[] args) {
		// 載入配置資訊 AppConfig
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("BMI:");
		// 取得 BMI 物件(Bean)
		BMI bmi = context.getBean(BMI.class);
		System.out.println(bmi.calc(170, 60));
		
		
	}
}
