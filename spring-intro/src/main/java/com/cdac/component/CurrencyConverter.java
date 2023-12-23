package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("currConv")
public class CurrencyConverter {

	public double convert(String from, String to, double amount) {
		if(from.equals("USD") && to.equals("INR"))
			return amount * 83.34;
		else
			return 0;
	}
}
