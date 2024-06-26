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
		customer.setId((long)123456789);
        customer.setName("John Doe");
        
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setId((long)987654321);
        customerDetails.setEmail("john@example.com");
        customerDetails.setPhone("123-456-7890");
        customerDetails.setCustomer(customer);
        
        customer.setCustomerDetails(customerDetails);
        
        entityTransaction.begin();
        entityManager.persist(customer);
        entityManager.persist(customerDetails);
        entityTransaction.commit();
        
        entityManager.close();
        entityManagerFactory.close();
	}
}
