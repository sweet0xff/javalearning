package org.xxx.test;

import org.junit.Test;
import org.xxx.model.dao.implement.BaseDao;
import org.xxx.model.entity.Admin;
import org.xxx.model.factory.DAOFactory;


public class TestAdminDao {

	BaseDao dbc = new BaseDao();
	@Test
	public void test() {
		Admin admin = new Admin();
		admin.setAname("admin");
		admin.setApassword("111");
		try {
			if(DAOFactory.getIAdminDAOInstance(dbc.getConnection()).findLogin(admin)){
				System.out.print("บวบว");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}