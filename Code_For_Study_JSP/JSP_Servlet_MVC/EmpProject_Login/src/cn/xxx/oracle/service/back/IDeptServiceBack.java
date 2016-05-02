package cn.mldn.oracle.service.back;

import java.util.List;
import java.util.Set;

import cn.mldn.oracle.vo.Dept;

public interface IDeptServiceBack {
	public boolean insert(Dept vo) throws Exception ;
	public boolean update(Dept vo) throws Exception ;
	/**
	 * 调用数据的删除操作，本方法要执行两个操作：<br>
	 * <li>先执行IEmpDAO接口的doRemoveBatchByDeptno()方法，删除掉部门的雇员
	 * <li>再执行IDeptDAO接口的doRemove()方法，删除掉部门信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(int id) throws Exception ;
	/**
	 * 调用数据的删除操作，本方法要执行两个操作：<br>
	 * <li>先执行IEmpDAO接口的doRemoveBatchByDeptno()方法，删除掉部门雇员
	 * <li>再执行IDeptDAO接口的doRemoveBatch()方法，删除掉多个部门信息
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBatch(Set<Integer> ids) throws Exception ;
	
	public List<Dept> list() throws Exception ;
	/**
	 * 查询一个部门的完整信息，本查询要调用如下的操作方法：<br>
	 * <li>要通过IDeptDAO接口的findByIdDetails()方法统计信息；
	 * <li>要通过IEmpDAO接口查询所有的雇员数据（分页显示）
	 * @param id
	 * @return 如果查询到了部门信息返回对象，如果没有查询到则返回null
	 * @throws Exception
	 */
	public Dept show(String column, String keyWord, int currentPage,
			int lineSize, int id) throws Exception;
	/**
	 * 查询部门的详细信息，调用IDeptDAO接口的findAllByDetails()方法实现
	 * @return
	 * @throws Exception
	 */
	public List<Dept> listDetails() throws Exception ;
} 
