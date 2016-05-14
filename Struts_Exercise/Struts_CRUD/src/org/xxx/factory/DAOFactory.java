package org.xxx.factory;

import java.sql.Connection;

import org.xxx.model.dao.IAdminDAO;
import org.xxx.model.dao.IStudentDAO;
import org.xxx.model.dao.impl.AdminDAO;
import org.xxx.model.dao.impl.StudentDAO;

public class DAOFactory {
	public static IAdminDAO getIAdminDAOInstance(Connection conn){
		return new AdminDAO(conn);
	}
	public static IStudentDAO getIStudentDAOInstance(Connection conn){
		return new StudentDAO(conn);
	}

}
