package org.xxx.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.xxx.model.dao.HibernateSessionFactory;
import org.xxx.model.entity.persist.Blog;
import org.xxx.model.entity.persist.Comment;

public class TestDemo {

	public static void main(String[] args) {
		
		Session session=HibernateSessionFactory.getSessionFactory().openSession();
		
		Date date = new Date();
		Blog blog = new Blog("Google AlphaGo","人工智能打败人类",date,"tech");
		
		Comment  c1= new Comment("机器人统治地球" ,new Date(),blog);
		Comment c2 = new Comment("人类要完",new Date(),blog);
		
		blog.getComments().add(c1);
		blog.getComments().add(c2);
		session.save(blog);
		session.beginTransaction().commit();
		
	}

}
