package com.cdac.component.banking.copy;

import org.springframework.stereotype.Component;

@Component("citibank-v2")
public class CitiBank implements Bank {

	@Override
	public boolean isAccountPresent(int acno) {
		if(acno == 11111)
			return true;
		return false;
	}
	@Override
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("customer of citi bank wants to withdraw money..");
	}

}
