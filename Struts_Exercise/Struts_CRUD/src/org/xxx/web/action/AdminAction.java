package org.xxx.web.action;

import org.xxx.factory.ServiceFactory;
import org.xxx.model.dao.entity.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String login(){
		boolean flag=true;
		 try {
			 flag = ServiceFactory.getIAdminServiceInstance().login(admin);
			 if(flag){
				 return "success";
			 }else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		 
	}
}
