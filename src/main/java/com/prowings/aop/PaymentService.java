package com.prowings.aop;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
	
	
	public void doPayment()
	{
		System.out.println("1---inside payment method!!!");
		System.out.println("2---executing the payment...");
		System.out.println("3---Debiting the amount from Debitor Acc...");
		System.out.println("4---Crediting the amount to Creditor Acc...");
		System.out.println("5---Payment completed successully!!!");
		
	}

}
