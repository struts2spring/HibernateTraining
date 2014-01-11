package com.example.training.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.example.training.util.HibernateUtil;

public class AppTest {

	@Test
	public void testOneToOneRead() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();

		// Add subscription
		SubscriptionEntity subOne = new SubscriptionEntity();
		subOne.setSubscriptionName("Entertainment");

		SubscriptionEntity subTwo = new SubscriptionEntity();
		subTwo.setSubscriptionName("Horror");

		Set<SubscriptionEntity> subs = new HashSet<SubscriptionEntity>();
		subs.add(subOne);
		subs.add(subTwo);

		// Add readers
		ReaderEntity readerOne = new ReaderEntity();
		readerOne.setEmail("demo-user1@mail.com");
		readerOne.setFirstName("demo");
		readerOne.setLastName("user");

		ReaderEntity readerTwo = new ReaderEntity();
		readerTwo.setEmail("demo-user2@mail.com");
		readerTwo.setFirstName("demo");
		readerTwo.setLastName("user");

		Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
		readers.add(readerOne);
		readers.add(readerTwo);

		readerOne.setSubscriptions(subs);
		readerTwo.setSubscriptions(subs);

		session.save(readerOne);
		session.save(readerTwo);

		txn.commit();
		session.close();
	}
}
