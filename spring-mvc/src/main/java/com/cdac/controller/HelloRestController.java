package com.cdac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	//@RequestMapping("/hello-rest.cdac")
		@GetMapping("/hello-rest.cdac")
	public String sayHello() {
		return "Hello from Spring REST Controller";
	}
	
}
