package org.thandav.hibernate;

import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thandav.hibernate.dto.Address;
import org.thandav.hibernate.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) throws RuntimeException{
		
		try{
			

		UserDetails user = new UserDetails();
		/*user.setUserId(3); Need not provide values for surrogate keys*/
		user.setUserName("First User");
		/*user.setAddress("ABC");*/
		user.setJoinedDate(new Date());
		user.setDescription("Joined today");
		
		Address address = new Address();
		address.setStreet("Lake Street");
		address.setPincode(12345);
		address.setState("MN");
		address.setCountry("USA");
		user.setHomeAddress(address);
		
		Address address2 = new Address();
		address2.setStreet("Van Buren");
		address2.setPincode(12344);
		address2.setState("MN");
		address2.setCountry("USA");
		user.setOfficeAddress(address2);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		org.hibernate.Transaction tx = session.getTransaction();
		tx.commit();
		session.close();
		
		/*user = null;
		session = sessionFactory.openSession();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User name retreived is " + user.getUserName());*/
		}
			finally {

			}
	}

}
