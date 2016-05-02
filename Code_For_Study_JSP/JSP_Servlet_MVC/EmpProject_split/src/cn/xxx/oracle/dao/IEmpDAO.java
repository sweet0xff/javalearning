package cn.mldn.oracle.dao;

import java.util.Set;

import cn.mldn.oracle.vo.Emp;

public interface IEmpDAO extends IDAO<Integer, Emp> {
	/**
	 * 批量删除数据，根据id删除，id是没有重复的
	 * @param ids 包含所有id数据的集合
	 * @return 如果全部删除成功返回true，否则返回false
	 * @throws Exception
	 */ 
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception ;
	/**
	 * 批量删除部门的雇员数据
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean doRemoveByDeptno(Set<Integer> ids) throws Exception ;
	/**
	 * 统计指定部门中的雇员人数
	 * @param deptno
	 * @return
	 * @throws Exception
	 */
	public Integer getAllCountByDeptno(Integer deptno) throws Exception ;
}
