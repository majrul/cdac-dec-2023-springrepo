package com.cdac.component.banking;

import org.springframework.stereotype.Component;

@Component
public class HdfcBank implements Bank {

	@Override
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("customer of hdfc bank wants to withdraw money..");
	}

}
