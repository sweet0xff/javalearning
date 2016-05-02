package org.xxx.model.dao;

import java.sql.SQLException;
import org.xxx.model.entity.User;

public interface IUserDAO extends IDAO<Integer, User> {

    /**
     * �û���¼���
     * @param vo ����Ҫ���м����û�ID��������Ϣ
     * @return �ɹ�����true,ʧ�ܷ���false
     * @throws SQLException
     */
    public boolean findLogin(User vo)throws SQLException;

    /**
     * �����û�������Ϣ
     * @param vo
     * @return �ɹ�����true ʧ�ܷ���fasle
     * @throws SQLException
     */
    public boolean doUpdateInfo(User vo)throws SQLException;
    
    /**
     * ��ѯ�û�����
     * @param vo
     * @return
     * @throws SQLException
     */
    public Integer doGetAllCount()throws SQLException;
    

    /**
     * �����û�״̬
     * @param mid �û�ID
     * @param status ״̬
     * @return
     * @throws SQLException
     */
    public boolean doUpdateStatus(String uid, Integer status) throws SQLException;

    
}
