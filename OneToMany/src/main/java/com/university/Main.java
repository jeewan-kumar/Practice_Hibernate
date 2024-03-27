package com.university;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        University university = new University();
        university.setName("Example University");

        Department department1 = new Department();
        department1.setName("Computer Science");
        department1.setUniversity(university);

        Department department2 = new Department();
        department2.setName("Mathematics");
        department2.setUniversity(university);

        university.getDepartments().add(department1);
        university.getDepartments().add(department2);

        entityTransaction.begin();
        entityManager.persist(university);
        entityManager.persist(department1);
        entityManager.persist(department2);
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}