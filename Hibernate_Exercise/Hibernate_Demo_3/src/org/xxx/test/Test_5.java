package org.xxx.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.Category;
import org.xxx.model.entity.persist.Item;

public class Test_5 {
	public static void main(String[] args) {
		Session session=HibernateSessionFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Category category = new Category();
		category.setCname("智能马桶");
		Item item  =new Item("家电",66666.66);
		category.getItems().add(item);
		session.save(category);
		transaction.commit();
		session.close();

		
	}
	

}
