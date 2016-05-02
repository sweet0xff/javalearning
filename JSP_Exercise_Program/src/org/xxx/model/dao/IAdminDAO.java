package org.xxx.model.dao;

import org.xxx.model.entity.Admin;

public interface IAdminDAO extends IDAO<String, Admin> {
	
	/**
	 * 管理员的登录验证
	 * @param vo 包含要验证的用户名和密码
	 * @return 成功返回true ,失败返回false
	 * @throws Exception
	 */
	public boolean findLogin(Admin vo)throws Exception;

}
