package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("eg-123")
public class Engine {

	public void accelerate() {
		System.out.println("vroom vroom..");
	}
}
