package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
