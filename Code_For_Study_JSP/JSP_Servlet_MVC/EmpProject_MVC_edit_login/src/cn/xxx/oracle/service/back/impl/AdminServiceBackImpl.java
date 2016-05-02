package cn.mldn.oracle.service.back.impl;

import cn.mldn.oracle.dbc.DatabaseConnection;
import cn.mldn.oracle.factory.DAOFactory;
import cn.mldn.oracle.service.back.IAdminServiceBack;
import cn.mldn.oracle.vo.Admin;

public class AdminServiceBackImpl implements IAdminServiceBack {
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean login(Admin vo) throws Exception {
		try {
			return DAOFactory.getIAdminDAOInstance(this.dbc.getConnection())
					.findLogin(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean insert(Admin vo) throws Exception {
		try {
			return DAOFactory.getIAdminDAOInstance(this.dbc.getConnection())
					.doCreate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

}
