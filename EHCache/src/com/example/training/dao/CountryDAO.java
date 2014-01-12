package com.example.training.dao;

import java.util.List;

import org.hibernate.Session;

import com.example.training.entity.Country;
import com.example.training.util.HibernateUtil;

public class CountryDAO {

	public Country findCountryByCode(String code) {
		Session session = HibernateUtil.currentSession();
		return (Country) session.createQuery("from Country as c where c.cnCode = :cnCode").setParameter("cnCode", code).uniqueResult();
	}

	public List<Country> getCountries() {
		Session session = HibernateUtil.currentSession();
		List<Country> countries = session
				.createQuery("from Country as c order by c.cnCode")
				.setCacheable(true).setCacheRegion("country").list();

		return countries;
	}
}
