package org.xxx.model.dao.implement;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.xxx.model.dao.IUserDAO;
import org.xxx.model.entity.User;

public class XXX implements IUserDAO {

	@Override
	public boolean doCreate(User vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(User vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllSplit(Integer currentPage, Integer lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findLogin(User vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdateInfo(User vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer doGetAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdateStatus(String uid, Integer status)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
