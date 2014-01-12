package com.example.training.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.training.dao.CountryDAO;
import com.example.training.entity.Country;
import com.example.training.timer.event.TestTimer;
import com.example.training.util.EMF;
import com.example.training.util.HibernateUtil;

public class AppTest {

	// @BeforeClass
	// public static void setData() {
	// EntityManager entityManager = EMF.getEntityManager();
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// try {
	//
	// entityTransaction.begin();
	// try {
	// Query query = entityManager.createNativeQuery(
	// "INSERT INTO COUNTRY VALUES ( 1 ,'ad','Andorra, Principality of');" );
	// query.executeUpdate();
	// } catch (Exception ex) {
	// if (entityTransaction.isActive())
	// entityTransaction.rollback();
	// }
	// } finally {
	// entityManager.close();
	// }
	//
	// }

	@Test
	public void testGetCountries() {
		try {
			CountryDAO dao = new CountryDAO();
			for (int i = 1; i <= 5; i++) {
				Session session = HibernateUtil.getSession();
				Transaction tx = session.beginTransaction();
				TestTimer timer = new TestTimer("testGetCountries");
				List<Country> countries = dao.getCountries();
				tx.commit();
				timer.done();
				HibernateUtil.closeSession();
				assertNotNull(countries);
				assertEquals(countries.size(), 229);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
