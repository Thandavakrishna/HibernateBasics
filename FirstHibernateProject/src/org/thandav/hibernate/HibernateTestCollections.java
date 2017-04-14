package org.thandav.hibernate;

import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thandav.hibernate.dto.Address;
import org.thandav.hibernate.dto.UserDetails;
import org.thandav.hibernate.dto.UserDetailsCollection;

public class HibernateTestCollections {
	
	public static void main(String[] args) throws RuntimeException{
		
		try{

		UserDetailsCollection user = new UserDetailsCollection();
		user.setUserId(1);
		user.setUserName("First User");
		
		Address address = new Address();
		address.setStreet("Lake Street");
		address.setPincode(12345);
		address.setState("MN");
		address.setCountry("USA");
		
		Address address2 = new Address();
		address2.setStreet("Van Buren");
		address2.setPincode(12344);
		address2.setState("MN");
		address2.setCountry("USA");
		
		user.getListOfAddresses().add(address);
		user.getListOfAddresses().add(address2);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		org.hibernate.Transaction tx = session.getTransaction();
		tx.commit();
		session.close();
		session = sessionFactory.openSession();
		user = null;
		user = session.get(UserDetailsCollection.class, 1);
		session.close();
		System.out.println(user.getListOfAddresses().size());
		
		}
			finally {

			}
	}

}
