package com.cdac.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.cdac")
	public String sayHello(Map map) {
		map.put("message", "Welcome to Spring MVC");
		map.put("luckyNumber", (int) Math.ceil(Math.random() * 10));
		return "hello.jsp";
	}
}
