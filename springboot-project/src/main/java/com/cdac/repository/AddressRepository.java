package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
