package org.xxx.test;


import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.Customer;
import org.xxx.model.entity.persist.Orders;

public class TestDemo {
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
	
    	Transaction tr = session.beginTransaction();
//		Customer c= new Customer("xxx","111", new Date(),20,new Timestamp(new Date().getTime()),"wuhan");
//		
//		session.save(c);
		Orders o1= new Orders("dingdan1",45.45,(Customer)session.get(Customer.class, 10));
		session.save(o1);
		tr.commit();
		session.close();

	}
	

}
