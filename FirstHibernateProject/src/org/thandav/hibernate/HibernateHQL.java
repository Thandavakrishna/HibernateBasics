package org.thandav.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.thandav.hibernate.dto.UserBasic;
import org.thandav.hibernate.dto.User_crud;

public class HibernateHQL {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Create
/*		for(int i=0; i <=10; i++){
			UserBasic user = new UserBasic();
			user.setUserName("User " +i);
			session.save(user);
		}
			*/
		String userInput = "5";
		String userName = "User 10";
		/*Query query = session.createQuery("from UserBasic");*/
		/*Query query = session.createQuery("select userName, userId from UserBasic where userId > "+ userInput);*/
		/*Query query = session.createQuery("from UserBasic where userId > ? and userName = ?");*/
		/*Query query = session.createQuery("from UserBasic where userId > :userId and userName = :userName");*/
		/*Query query = session.getNamedQuery("UserBasic.byId");*/
		/*Query query = session.getNamedQuery("UserBasic.byName");
		query.setString(0, "User 1");*/
		/*query.setInteger(0, Integer.parseInt(userInput));*/
		/*query.setString(1, userName);*/
		
		/*query.setInteger("userId", Integer.parseInt(userInput));
		query.setString("userName", userName);*/
		
		/*query.setFirstResult(5);
		query.setMaxResults(4);*/
		
		Criteria criteria = session.createCriteria(UserBasic.class);
		criteria.add(Restrictions.eq("userName", "User 1"));
		
		/*CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<UserBasic> criteria = builder.createQuery(UserBasic.class);
		((Criteria) criteria).add(Restrictions.eq("userName", "User 1"));*/
		
		/*List<UserBasic> UsersList = (List<UserBasic>)query.list();*/
		List<UserBasic> UsersList = (List<UserBasic>)criteria.list();	
		session.getTransaction().commit();
		session.close();
		
		for(UserBasic u : UsersList){
			System.out.println(u.getUserName());
		}
		System.out.println("Size of data returned is : "+UsersList.size());
/*		System.out.println(UsersList.get(0).toString()); */
		
	}

}
