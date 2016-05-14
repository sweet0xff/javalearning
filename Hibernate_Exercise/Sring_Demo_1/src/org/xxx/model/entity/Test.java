package org.xxx.model.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p = (Person) context.getBean("person");
		System.out.println(p);
		p.showPet();
		p.showGames();
		p.showFoods();
		p.showConfigMap();
	}

}
