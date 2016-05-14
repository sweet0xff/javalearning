package org.xxx.model.dao;

import org.xxx.model.dao.entity.Admin;

public interface IAdminDAO {
	
	public boolean doLogin(Admin vo) throws Exception;

}
