package org.xxx.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.TCustomer;

public class TestDemo {

	public static void main(String args[]){
		//查
//		Session session=HibernateSessionFactory.getSessionFactory().openSession();
//		TCustomer customer = (TCustomer)session.get(TCustomer.class, new Long(1));
//		System.out.println(customer.getName() + " === " + customer.getAddr());
//		session.close();
		
		//增
//		Session session=HibernateSessionFactory.getSessionFactory().openSession();
//		
//		org.hibernate.Transaction tr = session.beginTransaction();
//		
//		TCustomer customer=new TCustomer("xxx","111",new Date(),20,new Timestamp(new Long(23490)),"wuhan");
//		
//		session.save(customer);
//		try {
//			tr.commit();
//		} catch (Exception e) {
//			tr.rollback();
//			e.printStackTrace();
//		}
//		session.close();
		
		//删
//		Session session = HibernateSessionFactory.getSessionFactory().openSession();
//		Transaction tr=(Transaction) session.beginTransaction();
//		try {
//			TCustomer customer = (TCustomer) session.get(TCustomer.class, new Long(7));
//			session.delete(customer);
//			tr.commit();
//		} catch (Exception e) {
//			tr.rollback();
//			e.printStackTrace();
//		}finally{
//			session.close();
//		}
		
		//改
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		TCustomer customer=(TCustomer) session.get(TCustomer.class, new Long(9));
		try {
			customer.setAddr("美国");
			session.update(customer);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
