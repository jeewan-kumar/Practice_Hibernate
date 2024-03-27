package com.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		 Category category = new Category();
	        category.setName("Electronics");

	        Product product1 = new Product();
	        product1.setName("Laptop");
	        product1.setCategory(category);

	        Product product2 = new Product();
	        product2.setName("Smartphone");
	        product2.setCategory(category);

	        category.getProducts().add(product1);
	        category.getProducts().add(product2);

	        entityTransaction.begin();
	        entityManager.persist(category);
	        entityManager.persist(product1);
	        entityManager.persist(product2);
	        entityTransaction.commit();

	        entityManager.close();
	        entityManagerFactory.close();
	}
}
