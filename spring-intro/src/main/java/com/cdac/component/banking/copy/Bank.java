package com.cdac.component.banking.copy;

public interface Bank {

	public boolean isAccountPresent(int acno);
	public void withdraw(int atmId, int acno, double amount);

}
