package com.cdac;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/hello-rest.cdac")
	public String sayHello() {
		return "Hello from Spring REST Controller and Spring Boot";
	}
	
}
