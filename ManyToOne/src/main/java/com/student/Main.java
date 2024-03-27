package com.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Course course = new Course();
        course.setId(1);
		course.setName("Math");

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("John Doe");
        student1.setCourse(course);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Jane Smith");
        student2.setCourse(course);


        entityTransaction.begin();
        entityManager.persist(course);
        entityManager.persist(student1);
        entityManager.persist(student2);
        
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
	}
}
