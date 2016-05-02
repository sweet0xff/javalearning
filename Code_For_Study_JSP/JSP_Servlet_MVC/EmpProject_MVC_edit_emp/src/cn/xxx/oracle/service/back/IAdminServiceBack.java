package cn.mldn.oracle.service.back;

import cn.mldn.oracle.vo.Admin;

public interface IAdminServiceBack {
	public boolean login(Admin vo) throws Exception;

	public boolean insert(Admin vo) throws Exception;
}
