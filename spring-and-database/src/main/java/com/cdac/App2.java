package com.cdac;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ProductRepository productRepository = ctx.getBean(ProductRepository.class);
		//System.out.println(productRepository.getClass());
		
		/*Product product = new Product();
		product.setName("Nokia 6280");
		product.setPrice(6000);
		product.setQuantity(99);
	
		productRepository.save(product);*/
		
		List<Product> list = productRepository.findAll();
		for(Product product : list) {
			System.out.println(product);
		}
	}
}
