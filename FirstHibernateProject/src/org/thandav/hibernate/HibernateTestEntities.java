package org.thandav.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thandav.hibernate.dto.UserDetailsEntities;
import org.thandav.hibernate.dto.Vehicle;
import org.thandav.hibernate.dto.VehicleMappings;

public class HibernateTestEntities {
	
	public static void main(String[] args) throws RuntimeException{
		
		try{

		UserDetailsEntities user = new UserDetailsEntities();
		user.setUserName("First User");
		
		VehicleMappings vehicle = new VehicleMappings();
		vehicle.setVehicleName("First Vehicle");
		
		VehicleMappings vehicle2 = new VehicleMappings();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		org.hibernate.Transaction tx = session.getTransaction();
		tx.commit();
		session.close();
		
		}
			finally {

			}
	}

}
