package cn.mldn.oracle.service.back.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.oracle.dbc.DatabaseConnection;
import cn.mldn.oracle.factory.DAOFactory;
import cn.mldn.oracle.service.back.IEmpServiceBack;
import cn.mldn.oracle.vo.Emp;

public class EmpServiceBackImpl implements IEmpServiceBack {
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean insert(Emp vo) throws Exception {
		try {
			if (DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
					.findById(vo.getEmpno()) == null) {
				return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
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
	public boolean update(Emp vo) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
					.doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> updatePre(Integer id) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("emp",
					DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
							.findById(id));
			return map;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
					.doRemove(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean deleteBatch(Set<Integer> ids) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
					.doRemoveBatch(ids);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> list(String column, String keyWord,
			int currentPage, int lineSize) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("allEmps",
					DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
							.findAll(column, keyWord, currentPage, lineSize));
			map.put("empCount",
					DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
							.getAllCount(column, keyWord));
			return map;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Emp> list() throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
					.findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Emp show(int id) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection())
					.findById(id);
		} catch (Exception e) {
			throw e; 
		} finally {
			this.dbc.close();
		}
	}

}
