package com.cdac.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(path = "/hello.cdac", method = RequestMethod.GET)
	public String sayHello(Map map) {
		map.put("message", "Welcome to Spring MVC");
		map.put("luckyNumber", (int) Math.ceil(Math.random() * 10));
		return "hello.jsp";
	}

	@RequestMapping("/hello2.cdac")
	public String sayHello2(Model model) {
		model.addAttribute("message", "Welcome to Spring MVC");
		model.addAttribute("luckyNumber", (int) Math.ceil(Math.random() * 10));
		return "hello.jsp";
	}

	@RequestMapping("/hello3.cdac")
	public ModelAndView sayHello3() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Welcome to Spring MVC");
		mav.addObject("luckyNumber", (int) Math.ceil(Math.random() * 10));
		mav.setViewName("hello.jsp");
		return mav;
	}
}
