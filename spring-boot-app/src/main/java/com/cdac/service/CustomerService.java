package com.cdac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Address;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public int register(Customer customer) {
		//suppose we need to check if this customer has already registered before
		Optional<Customer> customerCheck = customerRepository.findByEmail(customer.getEmail());
		if(customerCheck.isEmpty()) {
			Address address = customer.getAddress();
			if(address != null)
				address.setCustomer(customer);
			Customer savedCustomer = customerRepository.save(customer);
			return savedCustomer.getId();
		}
		else
			throw new CustomerServiceException("Customer already registered!");
	}

	public void login() {
		
	}

}
