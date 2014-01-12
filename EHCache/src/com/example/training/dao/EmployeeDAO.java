
package com.example.training.dao;

import java.util.List;

import com.example.training.entity.Country;
import com.example.training.entity.Employee;
import com.example.training.util.HibernateUtil;

public class EmployeeDAO {

	public List<Employee> getEmployeesByCountry(Country country) {
		return HibernateUtil.currentSession()
				.createQuery("from Employee as e where e.country = :country " + " order by e.surname, e.firstname")
				.setParameter("country", country).list();
	}
}
