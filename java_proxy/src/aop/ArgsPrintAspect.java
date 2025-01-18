package aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 列印參數的切面 
// 目的:在指定方法執行之前可以印出參數內容
@Aspect // 此為切面程式
@Component // 可以被 Spring 所管理的物件
public class ArgsPrintAspect {
	
	// 前置通知
	@Before("execution(public aop.Calculator.add(int, int)")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 方法名稱
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("前置通知-方法名稱: %s 方法參數: %s%n", methodName, Arrays.toString(args));
	}
	
	
}
