package com.example.training.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.example.training.entity.Circle;
import com.example.training.entity.Rectangle;
import com.example.training.entity.Shape;
import com.example.training.util.HibernateUtil;

public class AppTest {

	@Test
	public void testMethod() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();

		Shape shape = new Shape("Sqaure");
		Rectangle rectangle = new Rectangle("Rectangle", 10, 20);
		Circle circle = new Circle("Circle", 4);
		session.save(shape);
		session.save(rectangle);
		session.save(circle);

		txn.commit();
		session.close();
	}
}
