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
	 * <li>key = emp，表示调用IEmpDAO的findById()方法，取得雇员信息
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
	 * 显示雇员完整信息
	 * @return
	 * @throws Exception
	 */
	public Emp show(int id) throws Exception ;
}
