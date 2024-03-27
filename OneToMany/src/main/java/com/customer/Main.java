package com.customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Customer customer = new Customer();
        customer.setName("John Doe");

        Order order1 = new Order();
        order1.setOrderNumber("ORD001");
        order1.setCustomer(customer);

        Order order2 = new Order();
        order2.setOrderNumber("ORD002");
        order2.setCustomer(customer);

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        entityTransaction.begin();
        entityManager.persist(customer);
        entityManager.persist(order1);
        entityManager.persist(order2);
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
	}
}
