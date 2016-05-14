package org.xxx.factory;

import org.xxx.model.service.IAdminService;
import org.xxx.model.service.IStudentService;
import org.xxx.model.service.impl.AdminService;
import org.xxx.model.service.impl.StudentService;

public class ServiceFactory {
	public static IAdminService getIAdminServiceInstance(){
		return new AdminService();
	}

	public static IStudentService getIStudentServiceInstance(){
		return new StudentService();
	}
}
