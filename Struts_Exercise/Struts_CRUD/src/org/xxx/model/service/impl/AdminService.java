package org.xxx.model.service.impl;

import org.xxx.factory.DAOFactory;
import org.xxx.model.dao.BaseDAO;
import org.xxx.model.dao.entity.Admin;
import org.xxx.model.service.IAdminService;

public class AdminService implements IAdminService {
	BaseDAO dao = new BaseDAO();

	@Override
	public boolean login(Admin vo) throws Exception {
		try {
			return DAOFactory.getIAdminDAOInstance(this.dao.getConnection()).doLogin(vo);
		} catch (Exception e) {
			throw e;
		}finally {
			dao.closeAll();
		}
	}

}
