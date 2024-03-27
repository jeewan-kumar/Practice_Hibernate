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
		
		Student student = new Student();
		student.setId(1);
        student.setName("John Doe");
        
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setId(1);
        studentDetail.setAddress("Gurugram sector 17");
        studentDetail.setPhone("7870794231");
        studentDetail.setStudent(student);
        
        student.setStudentDetail(studentDetail);
        
        entityTransaction.begin();
        entityManager.persist(student);
        entityManager.persist(studentDetail);
        entityTransaction.commit();
        
        entityManager.close();
        entityManagerFactory.close();
	}
}