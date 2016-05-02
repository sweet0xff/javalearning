package cn.mldn.oracle.service.back;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.oracle.vo.Emp;

public interface IEmpServiceBack {
	/**
	 * 执行数据增加操作，直接调用IEmpDAO的doCreate()方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Emp vo) throws Exception ;
	/**
	 * 执行数据修改操作，修改数据一定通过表单传递，调用IEmpDAO的doUpdate()方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Emp vo) throws Exception ;
	/**
	 * 在修改之前应该查询出已有的数据，调用的就是IEmpDAO的findById()方法
	 * @param id
	 * @return 考虑到日后的程序完结，此时返回的是Map集合，Map集合的返回值：<br>
	 * <li>key = emp，表示调用IEmpDAO的findByIdDetails()方法，取得雇员信息
	 * <li>key = allEmps：表示调用IEmpDAO接口的findAll()方法统计出所有的雇员信息
	 * <li>key = allDepts：表示调用IDeptDAO接口的findAll()方法统计出所有的部门信息
	 * @throws Exception
	 */
	public Map<String,Object> updatePre(Integer id) throws Exception ;
	/**
	 * 根据编号删除数据，调用IEmpDAO的doRemove()方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id) throws Exception ;
	/**
	 * 执行批处理删除操作，调用IEmpDAO的doRemoveBatch()方法
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBatch(Set<Integer> ids) throws Exception ;
	/**
	 * 分页显示数据
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> list(String column, String keyWord,
			int currentPage, int lineSize) throws Exception;
	/**
	 * 列出全部数据
	 * @return
	 * @throws Exception
	 */
	public List<Emp> list() throws Exception ;
	/**
	 * 显示雇员完整信息，调用的是IEmpDAO接口的findByIdDetails()方法
	 * @return
	 * @throws Exception
	 */
	public Emp show(int id) throws Exception ;
	/**
	 * 根据工资查询雇员信息（最高、最低工资查询），调用是IEmpDAO接口的findBySalDetails()方法
	 * @param sal 
	 * @return
	 * @throws Exception
	 */
	public List<Emp> showBySal(int deptno,double sal) throws Exception ;
	/**
	 * 雇员增加前执行的操作，本操作需要调用IEmpDAO、IDeptDAO接口方法
	 * @return 数据以Map集合返回，内容如下：<br>
	 * <li>key = allEmps：表示调用IEmpDAO接口的findAll()方法统计出所有的雇员信息
	 * <li>key = allDepts：表示调用IDeptDAO接口的findAll()方法统计出所有的部门信息
	 * @throws Exception
	 */
	public Map<String,Object> insertPre() throws Exception ;
	/**
	 * 雇员的详细信息列表，本操作要使用findAllByDetails()方法查询分页显示
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return 数据以Map集合返回，返回内容如下：<br>
	 * <li>key = allEmps：调用IEmpDAO接口的findAllByDetails()方法；
	 * <li>key = empCount：调用IEmpDAO接口的getAllCount()方法
	 * @throws Exception
	 */
	public Map<String,Object> listDetails(String column, String keyWord,
			int currentPage, int lineSize) throws Exception ;
}
