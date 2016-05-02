package cn.mldn.oracle.dao;

import java.util.List;
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
	/**
	 * 实现雇员的完整数据显示，此时会包含有领导信息（姓名、编号）和部门信息（名称、编号），使用多表查询
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	public List<Emp> findAllDetails(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception;
	/**
	 * 查询一个部门的完整雇员信息，包含领导信息、部门信息
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @param deptno
	 * @return
	 * @throws Exception
	 */
	public List<Emp> findAllDetailsByDeptno(String column, String keyWord,
			Integer currentPage, Integer lineSize, Integer deptno)
			throws Exception;
	/**
	 * 查询一个雇员的完整信息，例如，在更新雇员前至少应该知道他之前的部门和领导
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Emp findByIdDetails(Integer id) throws Exception ; 
	/**
	 * 根据雇员工资查询雇员信息（主要是为了方便根据最高、最低工资查询信息）
	 * @param id 
	 * @return
	 * @throws Exception
	 */
	public List<Emp> findBySalDetails(Integer deptno, Double sal)
			throws Exception; 
	
}
