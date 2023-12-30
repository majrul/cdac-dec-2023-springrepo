package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Status;
import com.cdac.entity.Order;
import com.cdac.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeOrder")
	public Status placeOrder(@RequestBody Order order) {
		orderService.placeOrder(order);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Order placed!");
		return status;
	}
}
