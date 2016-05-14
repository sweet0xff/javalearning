package org.xxx.model.service;

import org.xxx.model.dao.AdminDAO;
import org.xxx.model.entity.persist.Admin;

public class AdminService {
	AdminDAO dao = new AdminDAO();

	public Admin login(Admin vo) {
		return dao.doLogin(vo);
	}

}
