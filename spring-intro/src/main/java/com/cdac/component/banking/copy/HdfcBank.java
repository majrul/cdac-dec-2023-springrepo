package com.cdac.component.banking.copy;

import org.springframework.stereotype.Component;

@Component("hdfcbank-v2")
public class HdfcBank implements Bank {

	@Override
	public boolean isAccountPresent(int acno) {
		if(acno == 22222)
			return true;
		return false;
	}
	
	@Override
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("customer of hdfc bank wants to withdraw money..");
	}

}
