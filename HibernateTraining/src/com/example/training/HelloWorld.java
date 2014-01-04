package com.example.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.domain.User;

public class HelloWorld{

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		for (int i = 0; i < 10; i++) {

			User user = new User();
			//user.setUserId(1);
			user.setUserName("Pol" + i);

			session.save(user);
		}

		tx.commit();
		session.close();

	}

}
