package com.prowings.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {
	
	public static void main(String[] args) {
		
		System.out.println("main started!!");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		PaymentService service = ctx.getBean(PaymentService.class);
		
		service.doPayment();
		System.out.println("main ended!!");
	}

}
