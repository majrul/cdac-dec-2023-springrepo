package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.RegistrationStatus;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//spring can read the incoming json, parse it and store the data
	//in an object for us
	//in postman after select post method and entering the url,
	//select body, then select raw, then select json and enter the json data:
	/*
		 {
	  		"name" : "Majrul",
	  		"email" : "majrul@gmail.com",
	  		"password" : "123"
		}
		
		OR
		
		{
		  "name" : "Aditya",
		  "email" : "aditya@gmail.com",
		  "password" : "333",
		  "dateOfBirth" : "2000-11-11",
		  "address" : {
		      "line1" : "Star Apartments",
		      "line2" : "Near Andromeda Galaxy",
		      "pincode" : 40002,
		      "city" : "Mumbai",
		      "state" : "Maharashtra"
		  }
		}
	 */
	@PostMapping("/register")
	public RegistrationStatus register(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setStatusMessage("Customer registered successfully!");
			status.setCustomerId(id);
			return status;
		}
		catch (CustomerServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;			
		}
	}
}
