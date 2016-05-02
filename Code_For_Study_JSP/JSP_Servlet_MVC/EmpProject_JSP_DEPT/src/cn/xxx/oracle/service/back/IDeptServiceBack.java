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
} 
