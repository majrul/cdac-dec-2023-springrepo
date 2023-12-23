package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("my-car")
public class Car {
	
	@Autowired //DI //alternative to getBean(..);
	private Engine engine;

	public void start() {
		//Engine engine = new Engine();
		//Engine engine = ctx.getBean("eg-123");
		engine.accelerate();
	}
}
