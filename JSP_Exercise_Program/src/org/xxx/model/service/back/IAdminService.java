package org.xxx.model.service.back;

import org.xxx.model.entity.Admin;

public interface IAdminService {
    /**
     * 用户登录验证
     * @param vo 包含用户名和密码信息
     * @return
     * @throws Exception
     */
    public boolean login(Admin vo)throws Exception;
}
