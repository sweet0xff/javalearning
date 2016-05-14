package org.xxx.model.service;

import java.sql.SQLException;

import org.xxx.model.dao.UserDAO;
import org.xxx.model.entity.User;

public class UserService {
	UserDAO dao  = new UserDAO();
	
	public User login(User vo) throws SQLException{
		return dao.doLogin(vo);
	}

}
