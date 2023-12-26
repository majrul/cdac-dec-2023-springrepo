package com.cdac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Component("productInventory4")
public class ProductInventoryImpl4 implements ProductInventory {

	//@Autowired - autowired annotation doesn't works in case of injecting EntityManager object
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Product product) {
		em.persist(product);
	}

	@Override
	public List<Product> getAvailableProducts() {
		return em
				.createQuery("select p from Product p")
				.getResultList();
		//Query q = em.createQuery("select p from Product p");
		//List<Product> list = q.getResultList();
		//return list;
	}

}
