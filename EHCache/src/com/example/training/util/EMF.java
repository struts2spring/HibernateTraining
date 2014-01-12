package com.example.training.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("name");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}