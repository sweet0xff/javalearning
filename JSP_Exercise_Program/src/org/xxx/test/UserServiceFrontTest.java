package org.xxx.test;

import org.junit.Test;
import org.xxx.model.entity.User;
import org.xxx.model.factory.ServiceFrontFactory;

public class UserServiceFrontTest {

	@Test
	public void testRegist() {
		User user = new User();
		user.setUname("ถþนท");
		user.setUaccount("ถþนท");
		user.setUpassword("111");
		try {
			if(ServiceFrontFactory.getIUserServiceFrontInstance().regist(user)){
				System.out.print("hello,world");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
