package org.xxx.model.service.front.implement;

import org.xxx.model.dao.implement.BaseDao;
import org.xxx.model.entity.User;
import org.xxx.model.factory.DAOFactory;
import org.xxx.model.service.front.IUserServiceFront;

public class UserServiceFront implements IUserServiceFront {

	BaseDao dbc = new BaseDao();

	@Override
	public boolean regist(User vo) throws Exception {
		try {
			return DAOFactory.getIUserDAOInstance(dbc.getConnection()).doCreate(vo);
		} catch (Exception e) {
			throw e;
		}finally{
			dbc.close();
		}
	}

	@Override
	public boolean login(User vo) throws Exception {
		try {
			 return DAOFactory.getIUserDAOInstance(dbc.getConnection()).findLogin(vo);
		} catch (Exception e) {
			throw e;
		}finally{
			dbc.close();
		}
	}

	@Override
	public User updatePre(String mid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
