package aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 列印參數的切面 
// 目的:在指定方法執行之前可以印出參數內容
@Aspect // 此為切面程式
@Component // 可以被 Spring 所管理的物件
public class ArgsPrintAspect {
	// 切點方法
	@Pointcut(value = "execution(* aop.*.*(..))")
	public void ptAll() {}
	
	@Pointcut(value = "execution(public int aop.Calculator.add(int, int))")
	public void ptAdd() {}
	
	@Pointcut(value = "execution(public int aop.Calculator.div(int, int))")
	public void ptDiv() {}
	
	// 前置通知
	//@Before("execution(public int aop.Calculator.add(int, int))") // 要作用的指定方法
	//@Before("execution(public int aop.Calculator.*(int, int))") // 要作用的所有方法
	//@Before("execution(public int aop.Calculator.*(int, int)) || execution(public double aop.BMI.*(double, double))") // 要作用的所有方法
	//@Before("execution(* aop.*.*(..))") // 要作用的所有方法
	//                 └ *任何權限與回傳值 
	//                       └ *任何類
	//                         └ *任何方法
	//                           └ ..任何參數
	@Before(value = "ptAll()")
	//@Before(value = "ptAll() && !ptAdd()")
	public void beforeAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 方法名稱
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("前置通知-方法名稱: %s 方法參數: %s%n", methodName, Arrays.toString(args));
	}
	
	// 後置通知(不論是否發生錯誤都會通知)
	@After(value = "ptAdd()")
	public void afterAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 方法名稱
		System.out.printf("後置通知-方法名稱: %s %n", methodName);
	}
	
	// 異常通知
	@AfterThrowing(value = "ptDiv()", throwing = "e")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName(); // 方法名稱
		System.out.printf("異常通知-方法名稱: %s 錯誤訊息: %s%n", methodName, e);
	}
	
}










