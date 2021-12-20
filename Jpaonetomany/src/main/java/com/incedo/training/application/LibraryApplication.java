package com.incedo.training.application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.incedo.training.entity.Book;
import com.incedo.training.entity.Library;

public class LibraryApplication {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("jpaonetomanyassig");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();

			transaction.begin();

			Library libraryChennai = new Library();
			libraryChennai.setLibraryContactNo("040-2323432423");
			libraryChennai.setLibraryLocation("chennai");
			libraryChennai.setLibraryRegno("476AB8");

			Book bookJava = new Book();
			bookJava.setLibrary(libraryChennai);
			bookJava.setName("java");

			Book bookPython = new Book();
			bookPython.setLibrary(libraryChennai);
			bookPython.setName("python");

			List<Book> bookList = new ArrayList<Book>();
			bookList.add(bookPython);
			bookList.add(bookJava);
			

			libraryChennai.setBookList(bookList);

			entityManager.persist(libraryChennai);

			System.out.println("Library saved");

		} 
		
		catch (Exception e) {
			System.out.println(e);
			if(transaction!=null) {
				transaction.rollback();
			}
			 
		} 
		
		finally {
			if (transaction.isActive()) {
				transaction.commit();
			}

			if (entityManager != null) {
				entityManager.close();
			}
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}
	}

}
