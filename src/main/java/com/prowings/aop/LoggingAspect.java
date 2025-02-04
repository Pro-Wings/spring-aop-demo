package com.prowings.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.prowings.aop.PaymentService.*(..))")
    public void logBeforeMethod() {
        System.out.println(">>>>> Logging BEFORE method<<<<<<<<");
    }

	@After("execution(* com.prowings.aop.PaymentService.*(..))")
	public void logAfterMethod() {
		System.out.println(">>>>> Logging AFTER method<<<<<<<<");
	}

	@AfterReturning("execution(* com.prowings.aop.PaymentService.*(..))")
	public void logAfterReturningMethod() {
		System.out.println(">>>>> Logging AFTER RETURNING method<<<<<<<<");
	}

    @AfterThrowing(pointcut = "execution(* com.prowings.aop.PaymentService.*(..))", throwing = "ex")
	public void logAfterThrowingMethod(JoinPoint joinPoint, Exception ex) {
		System.out.println(">>>>> Logging AFTER THROWING method<<<<<<<<");
		System.out.println("Cause of exception is : "+ex.getMessage());
	}

    @Around("execution(* com.prowings.aop.PaymentService.doTransfer(..))")
    public Object logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    	System.out.println(">>>>> Logging AROUND method started!!!<<<<<<<<");

    	long start = System.currentTimeMillis();
    	Object o = proceedingJoinPoint.proceed(); //calling actual method
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("Total Execution Time : " +timeTaken + "ms");
    	System.out.println(">>>>>> Result : "+o);
    	System.out.println(">>>>> Logging AROUND method ended!!!<<<<<<<<");
    	return o;
    }


}
