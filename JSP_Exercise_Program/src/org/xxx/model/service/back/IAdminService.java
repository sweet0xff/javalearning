package org.xxx.model.service.back;

import org.xxx.model.entity.Admin;

public interface IAdminService {
    /**
     * �û���¼��֤
     * @param vo �����û�����������Ϣ
     * @return
     * @throws Exception
     */
    public boolean login(Admin vo)throws Exception;
}
