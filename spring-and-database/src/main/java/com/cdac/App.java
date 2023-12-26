package com.cdac;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ProductInventory productInventory = (ProductInventory) ctx.getBean("productInventory3");
		
		//entity classes are not instantiated using Spring
		/*Product product = new Product();
		product.setName("Nokia 6600");
		product.setPrice(5000);
		product.setQuantity(99);
	
		productInventory.add(product);*/
		
		//long ms1 = System.currentTimeMillis();
		List<Product> list = productInventory.getAvailableProducts();
		//long ms2 = System.currentTimeMillis();
		//System.out.println("overall approx time taken : " + (ms2 - ms1) + " ms");
		
		for(Product product : list) {
			System.out.println(product);
		}
	}
}
