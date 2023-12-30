package com.cdac.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.CustomerDetails;
import com.cdac.dto.LoginDetails;
import com.cdac.dto.LoginStatus;
import com.cdac.dto.RegistrationStatus;
import com.cdac.dto.Status;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer/register")
	public Status register(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setMessageIfAny("Registration successful!");
			status.setCustomerId(id);
			return status;
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/customer/registerv2")
	public ResponseEntity<Status> registerv2(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setMessageIfAny("Registration successful!");
			status.setCustomerId(id);
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
				
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			
			return new ResponseEntity<Status>(status, responseHeaders, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/customer/registerv3")
	public ResponseEntity<Status> registerv3(CustomerDetails customerDetails) {
		try {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDetails, customer);
			
			//storing the uploaded file
			try {
				String fileName = customerDetails.getProfilePic().getOriginalFilename();
				//TODO:here should be the code to generate a unique name for the file before proceeding further
				String generatedFileName = fileName; //replace this later
				
				customer.setProfilePic(generatedFileName);
				
				InputStream is = customerDetails.getProfilePic().getInputStream();
				FileOutputStream os = new FileOutputStream("c:/uploads/" + generatedFileName);
				FileCopyUtils.copy(is, os);
			}
			catch (IOException e) {
				//hoping no error here hence keeping it blank
			}
			
			int id = customerService.register(customer);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setMessageIfAny("Registration successful!");
			status.setCustomerId(id);
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
				
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			
			return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/customer/login")
	public Status login(@RequestBody LoginDetails loginDetails) {
		try {
			Customer customer = customerService.login(loginDetails.getEmail(), loginDetails.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(true);
			status.setMessageIfAny("Login successful!");
			status.setCustomerId(customer.getId());
			status.setName(customer.getName());
			//status.setCustomer(customer);
			return status;
		}
		catch (CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/customer/update")
	public Status update(@RequestBody Customer customer) {
		try {
			customerService.update(customer);
			
			Status status = new Status();
			status.setStatus(true);
			status.setMessageIfAny("Customer updated!");
			return status;
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
	
	@GetMapping("/customer/fetch/{id}")
	public Customer fetchById(@PathVariable int id) {
		return customerService.fetchById(id);
		//how will we write try catch this time?
	}
		
	/*@GetMapping("/customer/fetchv2/{id}")
	public Customer fetchByIdv2(@PathVariable int id) {
		Customer customer = customerService.fetchById(id);
		customer.setProfilePic("/customer/fetch/profilePic/"+id);
		return customer;
	}*/
	
	@GetMapping(path = "/customer/fetch/profilePic/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getProfilePic(@PathVariable int id) throws IOException {
		Customer customer = customerService.fetchById(id);
	    return Files.readAllBytes(Paths.get("c:/uploads/" + customer.getProfilePic()));
	}

}
