package com.auther;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Author author = new Author();
		author.setId(1);
        author.setName("John Doe");

        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("Book 1");
        book1.setAuthor(author);

        Book book2 = new Book();
        book2.setId(2);
        book2.setTitle("Book 2");
        book2.setAuthor(author);

        entityTransaction.begin();
        entityManager.persist(author);
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
	}
}
