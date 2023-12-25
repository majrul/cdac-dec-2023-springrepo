package com.cdac.component.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SbiAtm implements Atm {

	@Autowired
	private Bank bank;
	
	@Override
	public void withdraw(int acno, double amount) {
		System.out.println("customer at sbi atm to withdraw money..");

		//if we create object, then it leads to tight coupling
		//Bank bank = new HdfcBank();
		bank.withdraw(111, acno, amount);
	}

}
