package org.xxx.test;

import org.hibernate.Session;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.TCustomer;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		TCustomer customer = (TCustomer) session.get(TCustomer.class, new Long(1));
		System.out.print(customer.getName());
		
		
		
		
	}
}
