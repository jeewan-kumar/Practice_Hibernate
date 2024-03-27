package com.comment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Post post = new Post();
        post.setTitle("Sample Post");

        Comment comment1 = new Comment();
        comment1.setContent("First comment");
        comment1.setPost(post);

        Comment comment2 = new Comment();
        comment2.setContent("Second comment");
        comment2.setPost(post);

        post.getComments().add(comment1);
        post.getComments().add(comment2);

        entityTransaction.begin();
        entityManager.persist(post);
        entityManager.persist(comment1);
        entityManager.persist(comment2);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
	}
}
