package com.example.training.test;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.example.training.util.HibernateUtil;

public class AppTest {

	@Test
	public void testOneToOneRead() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();

		

		txn.commit();
		session.close();
	}
}
