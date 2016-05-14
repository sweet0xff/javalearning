package org.xxx.test;

import java.nio.channels.SeekableByteChannel;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.Customer;
import org.xxx.model.entity.persist.Orders;

public class Test_2 {

	public static void main(String[] args) {

		Customer customer = new Customer("111","111", new Date(),20,new Timestamp(new Date().getTime()),"美国");
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction transaction = (Transaction)session.beginTransaction();

		Orders o1= new Orders("11-1",78.56,customer);
		Orders o2= new Orders("11-2",87.23,customer);

		customer.getOrders().add(o1);
		customer.getOrders().add(o2);
		session.save(customer);
		transaction.commit();
		
		session.close();
		
	}

}
