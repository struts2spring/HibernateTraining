package com.example.training.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.example.training.util.HibernateUtil;

public class AppTest {

	@Test
	public void testOneToOneRead() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Country countryIndia = new Country("India", 50000000);

		State mpState = new State("Madhya Pradesh", 1000000);
		State maharastraState = new State("Maharastra", 2000000);

		countryIndia.getListOfStates().add(mpState);
		countryIndia.getListOfStates().add(maharastraState);

		
		session.save(countryIndia);

		txn.commit();
		session.close();
	}
}
