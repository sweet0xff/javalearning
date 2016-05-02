package org.xxx.model.service.back;

import java.util.List;

import org.xxx.model.entity.User;

public interface IUserServiceBack {
    /**
     * ʵ��ȫ���û��ķ�ҳ��ʾ�������IUserDAO�ӿ��е����·���:
     *  <li>����IUserDAO�ӿ��е�findAllSplit()����</li>
     *  <li>����IUserDAO�ӿ��е�getAllCount()����</li>
     * @param currentPage ��ʾ��ǰҳ
     * @param lineSize ��ʾÿҳ��ʾ��¼��
     * @return
     * @throws Exception
     */
    public List<User> listSplit(Integer currentPage, Integer lineSize) throws Exception;

    /**
     * ����id��ѯ����,��ѯһ����Ա��������Ϣ
     * @param uid Ҫ��ѯ�û��ı��
     * @return
     * @throws Exception
     */
    public User show(Integer uid)throws Exception;
    
    /**
     * ͳ���û�����
     * @return
     * @throws Exception
     */
    public Integer findAllCount()throws Exception;
    
    /**
     * ��������Ա���ļ���
     * @return
     * @throws Exception
     */
    public List<User> findAll() throws Exception;

    
}
