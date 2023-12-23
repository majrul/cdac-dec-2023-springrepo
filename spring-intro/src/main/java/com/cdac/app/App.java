package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Calculator;
import com.cdac.component.Car;
import com.cdac.component.CurrencyConverter;
import com.cdac.component.HelloWorld;
import com.cdac.component.Welcome;

public class App {

	public static void main(String[] args) {
		//Loading Spring's IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		//Accessing a bean
		HelloWorld hw = (HelloWorld) ctx.getBean("hello");
		System.out.println(hw.sayHello("Majrul"));
		//Why are we using Spring?
		//When we can create an object like this: HelloWorld hw = new HelloWorld();
		//answer to this question is pending as of now
		
		Welcome w = (Welcome) ctx.getBean("welcome");
		w.greet();
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		System.out.println(c.sub(10, 20));		
		
		CurrencyConverter cc = (CurrencyConverter) ctx.getBean("currConv");
		System.out.println(cc.convert("USD", "INR", 100));
		
		Car car = (Car) ctx.getBean("my-car");
		car.start();
	}
}
