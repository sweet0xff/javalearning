package org.xxx.web.action;

import org.xxx.model.entity.persist.Admin;
import org.xxx.model.service.AdminService;

public class AdminAction {

	private Admin admin;
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String login(){
		Admin returnModel = adminService.login(admin);
		if(returnModel != null){
			return "success";
		}
		return "error";
	}
}
