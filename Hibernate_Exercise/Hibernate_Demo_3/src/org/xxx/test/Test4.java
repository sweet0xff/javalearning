package org.xxx.test;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.Customer;
import org.xxx.model.entity.persist.Email;

public class Test4 {
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		//双向一对一
		Customer customer= new Customer("PHP","222",new Date(),19,new Timestamp(new Date().getTime()),"德国");
		Email email = new Email("xxx@j.com");
		customer.setEmail(email);
		email.setCustomer(customer);

		session.save(customer);
		transaction.commit();
		session.close();
		
		
		
	}

}
