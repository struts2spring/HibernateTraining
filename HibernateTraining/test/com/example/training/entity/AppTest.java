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

		AccountEntity account = new AccountEntity();
		account.setAccountNumber("123-345-65454");

		// Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");

		// Save Account
		session.saveOrUpdate(account);
		// Save Employee
		emp.setAccount(account);
		session.saveOrUpdate(emp);

		txn.commit();
		session.close();
	}
}
