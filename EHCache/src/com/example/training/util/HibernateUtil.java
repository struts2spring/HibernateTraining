package com.example.training.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

	/**
	 * Parameter used to define the XML Hibernate configuration file
	 */
	private static final String HIBERNATE_CONFIGURATION_FILE_PROPERTY = "hibernate.configuration.file";

	/**
	 * Class logger
	 */
	private static Logger log = LoggerFactory.getLogger(HibernateUtil.class);

	/**
	 * The one and only session manager instance
	 */
	private static HibernateUtil hibernateUtil = new HibernateUtil();
	/**
	 * The one and only Hibernate session factory.
	 */
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException ex) {
			throw new RuntimeException("Configuration problem: " + ex.getMessage(), ex);
		}
	}

	/**
	 * The thread-local Hibernate session object
	 */
	private static final ThreadLocal threadLocal = new ThreadLocal();

	public static Session getSession() throws HibernateException {
		return currentSession();
	}

	public static Session currentSession() throws HibernateException {
		log.debug("Hibernate Util :Fetching a hibernate session");
		Session session = (Session) threadLocal.get();
		// Open a new Session, if this Thread has none yet
		if (session == null) {
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		if (!session.isOpen()) {
			session = null;
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}

		
		log.debug("Hibernate Util : :Fetching a hibernate session done.");
		return session;
	}

	/**
	 * Close the current Hibernate session
	 * 
	 * @throws HibernateExceptiong
	 * @throws InfrastructureException
	 */
	public static void closeSession() throws HibernateException {
		log.debug("Hibernate Util  : closeSession");
		Session s = (Session) threadLocal.get();
		threadLocal.set(null);
		if (s != null && s.isOpen()) {
			log.debug("Hibernate Util : : closing session");
			s.close();
			log.debug("Hibernate Util : : session closed");
		}
		s = null;
	}


	/**
	 * Disconnect the current session from the current thread
	 * 
	 * @return
	 * @throws HibernateException
	 * @throws HibernateException
	 */
	public static Session disconnectSession() throws HibernateException {
		Session session = currentSession();
		if (session.isConnected() && session.isOpen()) {
			session.disconnect();
		}
		return session;
	}

	/**
	 * Returns an instance of a session mananger used to obtain a Hibernate
	 * Session object.
	 * 
	 * @return the Hibernate Util :.
	 */
	public static HibernateUtil getInstance() {
		return hibernateUtil;
	}

	public static Session openSession() throws HibernateException {
		return hibernateUtil.currentSession();
	}

}