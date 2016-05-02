package org.xxx.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.xxx.model.entity.User;
import org.xxx.model.factory.ServiceBackFactory;

public class TestGetAllUser {

	@Test
	public void test() throws Exception {
		List<User> ulist = new ArrayList<User>();
		ulist = ServiceBackFactory.getIUserServiceBackInstance().findAll();
		for (User u : ulist) {
			System.out.println(u.getUid() + "--" + u.getUname());
		}
		
	}

}
