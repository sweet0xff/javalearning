package cn.mldn.oracle.factory;

import java.sql.Connection;

import cn.mldn.oracle.dao.IAdminDAO;
import cn.mldn.oracle.dao.IDeptDAO;
import cn.mldn.oracle.dao.IEmpDAO;
import cn.mldn.oracle.dao.impl.AdminDAOImpl;
import cn.mldn.oracle.dao.impl.DeptDAOImpl;
import cn.mldn.oracle.dao.impl.EmpDAOImpl;

public class DAOFactory {
	public static IEmpDAO getIEmpDAOInstance(Connection conn) {
		return new EmpDAOImpl(conn) ;
	}
	public static IDeptDAO getIDeptDAOInstance(Connection conn) {
		return new DeptDAOImpl(conn) ;
	}
	public static IAdminDAO getIAdminDAOInstance(Connection conn) {
		return new AdminDAOImpl(conn) ;
	}
}
