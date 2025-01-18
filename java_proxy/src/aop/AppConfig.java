package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 此程式為系統配置程式
@EnableAspectJAutoProxy // 啟用 AOP 代理機制
@ComponentScan(basePackages = "aop") // 掃描要給 spring 管理的資源套件 
public class AppConfig {
	
	@Bean
	public Calculator calculator() {
		return new CalculatorImpl();
	}
	
	@Bean
	public BMI bmi() {
		return new BMIImpl();
	}
	
}
