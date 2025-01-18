package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BMIAspect {
	
	@Pointcut(value = "execution(* aop.BMI.*(..))")
	public void ptBMI() {}
	
	@Before(value = "ptBMI()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("前置通知: 保存 h, w");
	}
	
	@After(value = "ptBMI()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("後置通知: 統計使用次數");
	}
	
	@AfterThrowing(value = "ptBMI()", throwing = "e")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception e) {
		System.err.println("例外通知: 保存例外 log 紀錄");
	}
	
	@AfterReturning(value = "ptBMI()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, double result) {
		System.out.println("返回通知: 保存 bmi 的計算結果");
	}
	
}
