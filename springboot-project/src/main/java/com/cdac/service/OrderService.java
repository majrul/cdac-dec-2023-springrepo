package com.cdac.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.entity.Order;
import com.cdac.entity.Order.Status;
import com.cdac.entity.OrderItem;
import com.cdac.entity.Product;
import com.cdac.repository.OrderRepository;
import com.cdac.repository.ProductRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	public void placeOrder(Order order) {
		System.out.println(order.getCustomer().getId());
		double totalAmount = 0;
		for(OrderItem item : order.getOrderItems()) {
			item.setOrder(order);
			Product product = productRepository.findById(item.getProduct().getId()).get();
			//check if stock is available and update the same
			double subTotal = product.getPrice() * item.getQuantity();
			item.setSubTotal(subTotal);
			totalAmount += subTotal;
		}
		order.setTotalAmount(totalAmount);
		order.setDate(LocalDate.now());
		order.setStatus(Status.CONFIRMED);
		orderRepository.save(order);
		if(order.getStatus() == Status.PAYMENT_PENDING) {
			//sendEmailReminder
			//sendSMSReminder
		}
	}
}
