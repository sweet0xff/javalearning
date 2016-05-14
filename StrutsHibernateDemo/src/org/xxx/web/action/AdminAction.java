package org.xxx.web.action;

import java.util.ArrayList;
import java.util.List;

import org.xxx.factory.ServiceFactory;
import org.xxx.model.entity.persist.Admin;
import org.xxx.model.entity.persist.Students;
import org.xxx.model.entity.vo.Students_Classtype;

public class AdminAction {
	List<Students_Classtype> slist= new ArrayList<Students_Classtype>();
	
	public List<Students_Classtype> getSlist() {
		return slist;
	}

	public void setSlist(List<Students_Classtype> slist) {
		this.slist = slist;
	}

	private  Admin admin = new Admin();

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String login(){
		Admin returnModel = ServiceFactory.getAdminServiceInstance().login(admin);
		if(returnModel != null){
			slist =ServiceFactory.getStudentsClasstypeServiceInstance().findAll();
			return "success";
		}else {
			return "error";
		}

	}
}
