package org.xxx.model.dao;

import java.util.List;
import java.util.Set;

/**
 * DAO�����Ĺ����ӿ�
 * @author Zeng Ge
 * @param <K> �������ͣ����ӽӿھ���
 * @param <V> VO���ͣ����ӽӿھ���
 */
public interface IDAO<K,V> {
	/**
	 * ���ݵ����Ӳ���
	 * @param vo ����Ҫ���ӵ����ݵ�VO�����
	 * @return �ɹ��򷵻�true ,ʧ�ܾͷ���false
	 * @throws Exception
	 */
	public boolean doCreate(V vo)throws Exception;
	
	/**
	 * ���ݵ�(����)ɾ������
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean doDelete(Set<K> ids) throws Exception;

	/**
	 * �޸Ĳ���
	 * @param vo �������µ����ݣ����µ������޸�ԭʼ���ݣ����µ�ʱ�򽫱����Ϊ��������
	 * @return ����޸ĳɹ��򷵻�true,����false
	 * @throws Exception
	 */
	public boolean doUpdate(V vo)throws Exception;
	
	/**
	 * ����IDɾ�����е�����
	 * @param ids Ҫɾ����ID�ļ���
	 * @return ����ɹ��򷵻�true
	 * @throws Exception
	 */
	
	public V findById(K id)throws Exception;
	
	/**
	 * ��ѯ�����û���Ϣ,����ҳ��ʾ
	 * @param currentPage ��ǰҳ
	 * @param lineSize ÿҳҪ��ʾ������
	 * @return
	 * @throws Exception
	 */
	public List<V> findAllSplit(Integer currentPage,Integer lineSize)throws Exception;

	/**
	 * ��ѯ���е�ȫ������
	 * @return ���û��������List��size()==0,������list���ϵ���ʽ����
	 * @throws Exception
	 */
	public List<V> findAll()throws Exception; 

	/**
	 * ����IDɾ�����е�����
	 * @param ids Ҫɾ����ID����
	 * @return ���ɾ���ɹ�����true�����򷵻�false
	 * @throws SQLException
	 */
	public boolean doRemoveBatch(Set<K> ids)throws Exception;
	
}

