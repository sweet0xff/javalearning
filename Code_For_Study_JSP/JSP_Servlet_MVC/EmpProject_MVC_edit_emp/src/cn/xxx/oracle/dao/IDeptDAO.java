package cn.mldn.oracle.dao;

import java.util.List;
import java.util.Set;

import cn.mldn.oracle.vo.Dept;

public interface IDeptDAO extends IDAO<Integer, Dept> {
	/**
	 * 批量删除数据，根据id删除，id是没有重复的
	 * @param ids 包含所有id数据的集合
	 * @return 如果全部删除成功返回true，否则返回false
	 * @throws Exception
	 */ 
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception ;
	/**
	 * 查询一个部门的信息，除了基本信息之外，还包含有统计信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Dept findByIdDetails(Integer id) throws Exception ;
	/**
	 * 查询所有部门的完整信息与统计信息
	 * @return
	 * @throws Exception
	 */
	public List<Dept> findAllDetails() throws Exception ;
}
