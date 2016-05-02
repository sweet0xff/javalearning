package cn.mldn.oracle.dao;

import cn.mldn.oracle.vo.Admin;

public interface IAdminDAO extends IDAO<String, Admin> {
	public boolean findLogin(Admin vo) throws Exception ;
}
