package org.thandav.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thandav.hibernate.dto.User_crud;

public class HibernateStates {

	public static void main(String[] args) {
		
/*		User_crud user = new User_crud();
		
		user.setUserName("Test user");*/
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User_crud user = session.get(User_crud.class, 1);
		
/*		session.save(user);
		
		user.setUserName("User Name");
		
		user.setUserName("User Name Again");*/
	
		session.getTransaction().commit();
		session.close();
		
		// To make the detached object persistent again, pass object to update method.
		
		/*user.setUserName("After session is closed");*/
		user.setUserName("After adding Hibernate Entity annotation");
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();

	}

}
