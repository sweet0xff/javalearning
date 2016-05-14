package org.xxx.test;

import org.hibernate.Session;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.Customer;

public class TestDemo_6 {
	public static void main(String agrs[])  {
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
	Customer customer= new Customer();
	customer.setName("hehe");

	session.beginTransaction().commit();

	}

}
