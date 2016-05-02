package org.xxx.model.dao;

import java.util.List;
import java.util.Set;

/**
 * DAO操作的公共接口
 * @author Zeng Ge
 * @param <K> 主键类型，由子接口决定
 * @param <V> VO类型，由子接口决定
 */
public interface IDAO<K,V> {
	/**
	 * 数据的增加操作
	 * @param vo 包括要增加的数据的VO类对象；
	 * @return 成功则返回true ,失败就返回false
	 * @throws Exception
	 */
	public boolean doCreate(V vo)throws Exception;
	
	/**
	 * 数据的(批量)删除功能
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean doDelete(Set<K> ids) throws Exception;

	/**
	 * 修改操作
	 * @param vo 包含了新的数据，以新的数据修改原始数据，更新的时候将编号作为更新条件
	 * @return 如果修改成功则返回true,否则false
	 * @throws Exception
	 */
	public boolean doUpdate(V vo)throws Exception;
	
	/**
	 * 根据ID删除表中的数据
	 * @param ids 要删除的ID的集合
	 * @return 如果成功则返回true
	 * @throws Exception
	 */
	
	public V findById(K id)throws Exception;
	
	/**
	 * 查询所有用户信息,并分页显示
	 * @param currentPage 当前页
	 * @param lineSize 每页要显示的数据
	 * @return
	 * @throws Exception
	 */
	public List<V> findAllSplit(Integer currentPage,Integer lineSize)throws Exception;

	/**
	 * 查询表中的全部数据
	 * @return 如果没有数据则List的size()==0,有则以list集合的形式返回
	 * @throws Exception
	 */
	public List<V> findAll()throws Exception; 

	/**
	 * 根据ID删除表中的数据
	 * @param ids 要删除的ID集合
	 * @return 如果删除成功返回true，否则返回false
	 * @throws SQLException
	 */
	public boolean doRemoveBatch(Set<K> ids)throws Exception;
	
}

