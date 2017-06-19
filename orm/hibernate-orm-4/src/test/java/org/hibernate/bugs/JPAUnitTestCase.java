package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// This test will FAIL, 
        // Because the Event entity with id = 1, has version fiel with no(null) value
        @Test
	public void hhh10702Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
                Long eventId = 1L;
		Event evnt = entityManager.find(Event.class, eventId);
                evnt.setTitle("Event 1 Title changed");
		entityManager.getTransaction().commit();
		entityManager.close();
	}
        
        // This test will PASS, 
        // Because the Event entity with id = 2, has version fiel with valie value (valid integer) 
        @Test
	public void usecaseToPassTest() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
                Long eventId = 2L;
		Event evnt = entityManager.find(Event.class, eventId);
                evnt.setTitle("Event 2");
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
