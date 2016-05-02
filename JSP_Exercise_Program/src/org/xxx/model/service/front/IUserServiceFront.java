package org.xxx.model.service.front;

import org.xxx.model.entity.User;

public interface IUserServiceFront {
    /**
     * �˷���������û�ע�����������
     * <li>����������ǰ��Ҫ�ж�Ҫ���ӵ������Ƿ���ڣ�ʹ��IMemberDAO�ӿ��е�findById()��������ѯҪ���ӵ������Ƿ���ڣ�������ڱ�ʾ����������</li>
     * @param vo Ҫ�������ݵ�vo����
     * @return �ɹ�����true,ʧ�ܷ���false
     * @throws Exception
     */
    public boolean regist(User vo)throws Exception;

    /**
     * �û���¼����������IMemberDAO�ӿ��е�findLogin()������
     * @param vo �������û���mid��������Ϣ
     * @return �ɹ�������ҳ��ʧ�ܷ��ص�½ҳ��
     * @throws Exception
     */
    public boolean login(User vo)throws Exception;

    /**
     * ���ݱ�Ų�ѯ�������е�ȫ����¼
     * @param mid
     * @return
     * @throws Exception
     */
    public User updatePre(String mid)throws Exception;

    /**
     * �û����ݸ��²���
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean update(User vo)throws Exception;
}
