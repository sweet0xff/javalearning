package org.xxx.model.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.xxx.model.dao.AdminDAO;
import org.xxx.model.entity.persist.Admin;
import org.xxx.model.service.AdminService;

@Transactional
public class AdminServiceImpl implements AdminService {
	private AdminDAO adminDao;
	
	public AdminDAO getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin login(Admin vo) {
		return adminDao.login(vo);
	}

}
