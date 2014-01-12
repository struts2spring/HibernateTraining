package com.example.training.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Vehical vehical = new Vehical(1l, "Old vehical");

		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicalName("Bike");
		twoWheeler.setStreeingHandle("bike handle");

		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicalName("Car");
		fourWheeler.setStreeingWheel("Car Wheel");
		
		session.save(vehical);
		session.save(twoWheeler);
		session.save(fourWheeler);

		tx.commit();
		session.close();

	}
}
