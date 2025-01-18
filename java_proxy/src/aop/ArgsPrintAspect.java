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
	//@Before("execution(public int aop.Calculator.add(int, int))") // 要作用的指定方法
	//@Before("execution(public int aop.Calculator.*(int, int))") // 要作用的所有方法
	//@Before("execution(public int aop.Calculator.*(int, int)) || execution(public double aop.BMI.*(double, double))") // 要作用的所有方法
	@Before("execution(* aop.*.*(..))") // 要作用的所有方法
	//                 └ *任何權限與回傳值 
	//                       └ *任何類
	//                         └ *任何方法
	//                           └ ..任何參數
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 方法名稱
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("前置通知-方法名稱: %s 方法參數: %s%n", methodName, Arrays.toString(args));
	}
	
	
}
