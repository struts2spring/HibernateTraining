package com.example.training.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.example.training.dao.CountryDAO;
import com.example.training.entity.Country;
import com.example.training.timer.event.TestTimer;
import com.example.training.util.HibernateUtil;

public class AppTest {

	@Test
	public void testGetCountries() {
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
	}
}
