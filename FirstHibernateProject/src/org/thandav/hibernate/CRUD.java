package org.thandav.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thandav.hibernate.dto.User_crud;

public class CRUD {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Create
/*		for(int i=0; i <=10; i++){
			User_crud user = new User_crud();
			user.setUserName("User " +i);
			session.save(user);
		}*/
		
		/*User_crud user = (User_crud)session.get(User_crud.class, 6);
		session.delete(user);*/
		User_crud user = (User_crud)session.get(User_crud.class, 5);
		user.setUserName("Updated User");
		session.update(user);
	
		session.getTransaction().commit();
		session.close();
		

	}

}
