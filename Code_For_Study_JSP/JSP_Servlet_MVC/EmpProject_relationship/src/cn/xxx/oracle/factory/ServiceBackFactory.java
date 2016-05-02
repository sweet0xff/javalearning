package cn.mldn.oracle.factory;

import cn.mldn.oracle.service.back.IDeptServiceBack;
import cn.mldn.oracle.service.back.IEmpServiceBack;
import cn.mldn.oracle.service.back.impl.DeptServiceBackImpl;
import cn.mldn.oracle.service.back.impl.EmpServiceBackImpl;

public class ServiceBackFactory { 
	public static IEmpServiceBack getIEmpServiceBackInstance() {
		return new EmpServiceBackImpl();
	}
	public static IDeptServiceBack getIDeptServiceBackInstance() {
		return new DeptServiceBackImpl() ;
	}
}
