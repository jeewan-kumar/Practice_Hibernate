package com.books;

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
        author.setName("Jane Austen");

        Book book1 = new Book();
        book1.setTitle("Pride and Prejudice");
        book1.setAuthor(author);

        Book book2 = new Book();
        book2.setTitle("Sense and Sensibility");
        book2.setAuthor(author);

        author.getBooks().add(book1);
        author.getBooks().add(book2);

        entityTransaction.begin();
        entityManager.persist(author);
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
	}
}
