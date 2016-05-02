package org.xxx.test;


import org.junit.Test;
import org.xxx.model.factory.ServiceBackFactory;

public class FindAllCountTest {

	@Test
	public void test() throws Exception {
		Integer count = ServiceBackFactory.getIUserServiceBackInstance().findAllCount();
		System.out.print(count);
	}

}
