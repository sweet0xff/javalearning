package cn.mldn.shop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * DAO操作的公共接口 
 * @param <K> 主键类型，由子接口决定
 * @param <V> VO类型，由子接口决定
 */
public interface IDAO<K,V> {
	/**
	 * 数据增加操作
	 * @param vo 包含了要增加数据的VO类对象
	 * @return 如果增加成功返回true，否则返回false
	 * @throws SQLException
	 */
	public boolean doCreate(V vo) throws SQLException;
	/**
	 * 数据修改操作
	 * @param vo 包含了新的数据，以新的数据修改原始数据，更新的时候会将编号作为更新条件
	 * @return 如果修改成功返回true，否则返回false
	 * @throws SQLException
	 */
	public boolean doUpdate(V vo) throws SQLException ;
	/**
	 * 根据ID删除表中的数据
	 * @param ids 要删除的ID集合
	 * @return 如果删除成功返回true，否则返回false
	 * @throws SQLException
	 */
	public boolean doRemoveBatch(Set<K> ids) throws SQLException ;
	/**
	 * 根据编号查询数据信息
	 * @param id 要查询的ID数据
	 * @return 如果现在存在有指定编号的数据，则会将数据以VO的形式返回，如果不存在会返回null
	 * @throws SQLException
	 */
	public V findById(K id) throws SQLException;
	/**
	 * 查询数据表中的全部数据
	 * @return 如果表中没有数据，则返回的List集合为空（size()==0），如果有数据，会将数据以List集合的形式返回
	 * @throws SQLException
	 */
	public List<V> findAll() throws SQLException ;
	/**
	 * 分页模糊查询表中的全部数据
	 * @param column 要模糊查询的数据列
	 * @param keyWord 模糊查询关键字，如果关键字为null（isEmpty()==true），则查询表中的全部数据
	 * @param currentPage 当前所在页
	 * @param lineSize 每页显示的数据行数
	 * @return 如果表中没有数据，则返回的List集合为空（size()==0），如果有数据，会将数据以List集合的形式返回
	 * @throws SQLException
	 */
	public List<V> findAll(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException;
	/**
	 * 统计数据表之中的数据量
	 * @param column 模糊查询的数据列
	 * @param keyWord 模糊查询的关键字
	 * @return 如果表中有记录，则返回COUNT()函数的统计结果，如果表中没有记录，返回0
	 * @throws SQLException
	 */
	public Integer getAllCount(String column,String keyWord) throws SQLException ;
}
