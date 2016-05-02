package cn.mldn.oracle.service.back.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.oracle.dbc.DatabaseConnection;
import cn.mldn.oracle.factory.DAOFactory;
import cn.mldn.oracle.service.back.IDeptServiceBack;
import cn.mldn.oracle.vo.Dept;

public class DeptServiceBackImpl implements IDeptServiceBack {
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean insert(Dept vo) throws Exception {
		try {
			if (DAOFactory.getIDeptDAOInstance(this.dbc.getConnection())
					.findById(vo.getDeptno()) == null) {
				return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection())
						.doCreate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Dept vo) throws Exception {
		try {
			return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection())
					.doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(int id) throws Exception {
		try {
			// 需要首先创建一个Set集合才可以调用批量删除部门雇员的方法
			Set<Integer> set = new HashSet<Integer>();
			set.add(id);
			// 如果雇员表之中有数据存在
			if (DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
					.getAllCountByDeptno(id) > 0) {
				// 执行删除此部门雇员的操作
				if (DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
						.doRemoveByDeptno(set)) { // 删除雇员成功
					return DAOFactory.getIDeptDAOInstance(
							this.dbc.getConnection()).doRemove(id);
				}
			} else { // 如果没有指定部门的雇员，那么直接删除部门
				return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection())
						.doRemove(id);
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean deleteBatch(Set<Integer> ids) throws Exception {
		try {
			// 此集合之中保存存在雇员的集合，和不存在雇员的集合
			Set<Integer> setExists = new HashSet<Integer>();
			Set<Integer> setNoExists = new HashSet<Integer>();
			Iterator<Integer> iter = ids.iterator();
			while (iter.hasNext()) {
				Integer deptno = iter.next();
				if (DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
						.getAllCountByDeptno(deptno) > 0) { // 此部门有雇员
					setExists.add(deptno); // 存在有雇员的部门编号
				} else {
					setNoExists.add(deptno); // 不存在有雇员的部门编号
				}
			}
			boolean flag = false; // 保存结果
			if (setExists.size() > 0) { // 存在有要删除数据
				if (DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
						.doRemoveByDeptno(setExists)) { // 删除雇员成功
					flag = DAOFactory.getIDeptDAOInstance(
							this.dbc.getConnection()).doRemoveBatch(setExists);
				}
			}
			if (setNoExists.size() > 0) { // 不存在雇员的部门
				flag = DAOFactory.getIDeptDAOInstance(this.dbc.getConnection())
						.doRemoveBatch(setNoExists);
			}
			return flag;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Dept> list() throws Exception {
		try {
			return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection())
					.findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

}
