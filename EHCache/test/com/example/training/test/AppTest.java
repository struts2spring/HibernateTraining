package com.example.training.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.example.training.entity.DepartmentEntity;
import com.example.training.util.HibernateUtil;

public class AppTest {

	@Test
	public void testOneToOneRead() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();

		// fetch the department entity from database first time
		DepartmentEntity department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
		System.out.println(department.getName());

		// fetch the department entity again; Fetched from first level cache
		department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
		System.out.println(department.getName());

		// Let's close the session
		session.getTransaction().commit();
		session.close();

		// Try to get department in new session
		Session anotherSession = HibernateUtil.getSessionFactory().openSession();
		anotherSession.beginTransaction();

		// Here entity is already in second level cache so no database query
		// will be hit
		department = (DepartmentEntity) anotherSession.load(DepartmentEntity.class, new Integer(1));
		System.out.println(department.getName());

		txn.commit();
		session.close();
	}
}
