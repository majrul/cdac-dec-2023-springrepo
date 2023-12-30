package com.cdac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public int register(Customer customer) {
		Long count = customerRepository.findIfCustomerExists(customer.getEmail());
		if(count == 1)
			throw new CustomerServiceException("Customer already registered!");
		else {
			customerRepository.save(customer);
			return customer.getId();
		}
	}
	
	public Customer login(String email, String password) {
		Optional<Customer> customer = customerRepository.findByEmailAndPassword(email, password);
		if(customer.isPresent())
			return customer.get();
		else
			throw new CustomerServiceException("Invalid Email/Password");
	}

	public Customer loginv2(String email, String password) {
		Long count = customerRepository.findIfCustomerIsPresent(email, password);
		if(count == 0)
			throw new CustomerServiceException("Invalid Email/Password");
		else {
			return customerRepository.findByEmail(email).get();
		}
	}

	public void update(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer fetchById(int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent())
			return customer.get();
		else
			throw new CustomerServiceException("Customer with id " + id + " does not exist!");
	}
}
