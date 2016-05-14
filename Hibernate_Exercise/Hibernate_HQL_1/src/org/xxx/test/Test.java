package org.xxx.test;

import java.util.List;

import org.xxx.model.entity.persist.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.xxx.model.dao.HibernateSessionFactory;

import sample.CustomerRecord;

public class Test {

	@org.junit.Test
	public void findById () {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		String hql= "from TCustomer c where c.name=?";
		Query query = session.createQuery(hql);
		query.setString(0, "马兰德龙");
		List<TCustomer> clist = query.list();
		for (TCustomer c : clist) {
			System.out.println(c.getAddr() + " " + c.getName());
			
		}
		session.close();
	}
	@org.junit.Test
	public void findOrderByCustomerId(){
		Session session=HibernateSessionFactory.getSessionFactory().openSession();
		TCustomer customer = (TCustomer)session.get(TCustomer.class, new Long(1));
		String hql= "from TOrder o where o.TCustomer = ? ";
		Query query=session.createQuery(hql);
		query.setEntity(0, customer);
		List<TOrder> olist = query.list();
			
		for (TOrder t : olist) {
			System.out.println(t.getOrderNumber());
			
		}
		session.close();
	}


	@org.junit.Test
	public void updateByName(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		String hql= "update TCustomer c set c.age=100 where name = '马兰德龙'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		
	}
	
	@org.junit.Test
	public void deleteByName(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		String hql= "delete TCustomer c where name='JAVA'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}
	
	@org.junit.Test
	public void testGroupBy(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		String hql= "select c.age,count(c) from TCustomer c  group by c.age order by count(c)";
		Query query = session.createQuery(hql);
		List<Object []> list = query.list();
		
		for (Object[] o : list) {
			
				System.out.print(o[0] + " ");
				System.out.println(o[1]);
		}
	}
}
