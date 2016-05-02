package org.xxx.model.factory;

import org.xxx.model.service.back.IAdminService;
import org.xxx.model.service.back.IUserServiceBack;
import org.xxx.model.service.back.implement.AdminService;
import org.xxx.model.service.back.implement.UserServiceBack;

public class ServiceBackFactory {
	
	public static IAdminService getIAminServiceInstance(){
		return new AdminService(); 
	}
	
	public static IUserServiceBack getIUserServiceBackInstance(){
		return new UserServiceBack();
	}


}
