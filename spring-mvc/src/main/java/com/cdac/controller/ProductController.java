package com.cdac.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.entity.Product;
import com.cdac.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/search-product")
	public String search(@RequestParam("id") int pid, Map map) {
		//int id = Integer.parseInt(request.getParameter("id"));
		Product product = productRepository.findById(pid).get();
		map.put("productData", product);
		return "viewProduct.jsp";
		/*Optional<Product> product = productRepository.findById(pid);
		if(product.isPresent()) {
			map.put("productData", product.get());
			return "viewProduct.jsp";
		}*/
	}
	
	@RequestMapping("/add-product")
	public String add(@RequestParam String name,
					  @RequestParam double price,
					  @RequestParam int quantity,
					  Map map) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setQuantity(quantity);
		productRepository.save(product);
		
		map.put("message", "Record added successfully!");
		return "addProduct.jsp";
	}
	
	//Spring can dynamically copy form data in an object for us
	//no need to use @requestparam multiple times
	@RequestMapping("/add-product-v2")
	public String addV2(Product product, Map map) {
		productRepository.save(product);		
		map.put("message", "Record added successfully!");
		return "addProduct.jsp";
	}
	
	@RequestMapping("/fetch-all-products")
	public String fetchAll(Map map) {
		List<Product> list = productRepository.findAll();
		map.put("listOfProducts", list);
		return "viewAllProducts.jsp";
	}
	
}
