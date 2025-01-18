package aop;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public Calculator calculator() {
		return new CalculatorImpl();
	}
	
}
