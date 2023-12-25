package com.cdac.component.banking.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sbiatm-v2")
public class SbiAtm implements Atm {

	@Autowired
	private List<Bank> banks;
	
	@Override
	public void withdraw(int acno, double amount) {
		System.out.println("customer at sbi atm to withdraw money..");
		
		Bank currentBank = null;
		for(Bank bank : banks) {
			if(bank.isAccountPresent(acno)) {
				currentBank = bank;
				break;
			}
		}
		
		currentBank.withdraw(111, acno, amount);
	}

}
