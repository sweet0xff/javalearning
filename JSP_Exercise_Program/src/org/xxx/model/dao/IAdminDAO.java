package org.xxx.model.dao;

import org.xxx.model.entity.Admin;

public interface IAdminDAO extends IDAO<String, Admin> {
	
	/**
	 * ����Ա�ĵ�¼��֤
	 * @param vo ����Ҫ��֤���û���������
	 * @return �ɹ�����true ,ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean findLogin(Admin vo)throws Exception;

}
