package org.xxx.factory;

import org.xxx.model.service.AdminService;
import org.xxx.model.service.ClasstypeService;
import org.xxx.model.service.StudentService;
import org.xxx.model.service.StudentsClasstypeService;

public class ServiceFactory {
	public static AdminService getAdminServiceInstance(){
		return new AdminService();
		
	}

	public static StudentsClasstypeService getStudentsClasstypeServiceInstance(){
		return new StudentsClasstypeService();
	}
	
	public static StudentService getStudentServiceInstance(){
		return new StudentService();
	}
	
	public static ClasstypeService getClasstypeServiceInstance(){
		
		return new ClasstypeService();
	}
	
}
