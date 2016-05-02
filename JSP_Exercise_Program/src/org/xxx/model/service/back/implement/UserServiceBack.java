package org.xxx.model.service.back.implement;

import java.util.List;

import org.xxx.model.dao.implement.BaseDao;
import org.xxx.model.entity.User;
import org.xxx.model.factory.DAOFactory;
import org.xxx.model.service.back.IUserServiceBack;

public class UserServiceBack implements IUserServiceBack {
	private BaseDao dbc = new BaseDao();
	
	@Override
	public List<User> listSplit(Integer currentPage, Integer lineSize)
			throws Exception {
		try {
			return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findAllSplit(currentPage, lineSize);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public User show(Integer uid) throws Exception {
		return null;
	}

	@Override
	public Integer findAllCount() throws Exception {
		try {
			return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).doGetAllCount();
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public List<User> findAll() throws Exception {
		try {
			return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	

}
