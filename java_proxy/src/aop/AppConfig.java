package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "aop") // 掃描要給 spring 管理的資源 
public class AppConfig {
	
	@Bean
	public Calculator calculator() {
		return new CalculatorImpl();
	}
	
}
