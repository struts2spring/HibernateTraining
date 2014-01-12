package com.example.training.db;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PopulateDBWithData {

	private static final Logger logger = LoggerFactory.getLogger(PopulateDBWithData.class);

	public static void main(String[] args) {
		initDatabaseSchema();
		// ClientManager clientManager = new ClientManager();

	}

	private static void initDatabaseSchema() {
		Session session = HibernateSessionUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.doWork(new RunH2ScriptWork("init-schema.sql"));

		session.getTransaction().commit();
	}
}
