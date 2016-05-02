package org.xxx.test;

import org.junit.Test;
import org.xxx.model.entity.User;
import org.xxx.model.factory.ServiceFrontFactory;

public class TestUserServlet {

	@Test
	public void test() throws Exception {
		User vo = new User();
		vo.setUaccount("zhangsan");
		vo.setUpassword("111");
	
		if(ServiceFrontFactory.getIUserServiceFrontInstance().login(vo)){
			System.out.print("hehe");
		}
	}

}
