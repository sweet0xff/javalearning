package org.xxx.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.Email;

public class TestDelete {

	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Email email=(Email)session.get(Email.class, 4);
		session.delete(email);
		transaction.commit();
		session.close();
		
	}
	
	
}
