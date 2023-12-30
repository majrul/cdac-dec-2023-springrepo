package com.cdac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select count(c) from Customer c where c.email = ?1")
	public Long findIfCustomerExists(String email);
	
	@Query("select count(c) from Customer c where c.email = ?1 and c.password = ?2")
	public Long findIfCustomerIsPresent(String email, String password);
	
	public Optional<Customer> findByEmail(String email);
	public Optional<Customer> findByEmailAndPassword(String email, String password);
}
