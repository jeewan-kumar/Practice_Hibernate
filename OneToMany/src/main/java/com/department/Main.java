package com.department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Department department = new Department();
        department.setName("Engineering");

        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setDepartment(department);

        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setDepartment(department);

        department.getEmployees().add(employee1);
        department.getEmployees().add(employee2);

        entityTransaction.begin();
        entityManager.persist(department);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
	}
}
