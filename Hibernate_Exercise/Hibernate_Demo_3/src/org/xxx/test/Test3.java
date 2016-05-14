package org.xxx.test;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.Customer;
import org.xxx.model.entity.persist.Orders;

public class Test3 {
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Customer customer = new Customer("ok","111",new Date(),32,new Timestamp(new Date().getTime()),"英国");
		
		//效率较低的一种操作方式.可加inverse="true"来解决
		Orders o1= new Orders("ok_1" ,89.33,customer);
		Orders o2 = new Orders("ok_2",89.323,customer);
		
		Transaction transaction =(Transaction)session.beginTransaction();
		session.save(customer);
		customer.getOrders().add(o1);
		customer.getOrders().add(o2);
		transaction.commit();
		session.close();
	}


}
