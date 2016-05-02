package cn.mldn.oracle.factory;

import cn.mldn.oracle.service.back.IEmpServiceBack;
import cn.mldn.oracle.service.back.impl.EmpServiceBackImpl;

public class ServiceBackFactory {
	public static IEmpServiceBack getIEmpServiceBackInstance() {
		return new EmpServiceBackImpl();
	}
}
