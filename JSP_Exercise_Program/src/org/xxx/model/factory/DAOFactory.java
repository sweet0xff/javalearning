package org.xxx.model.factory;

import java.sql.Connection;

import org.xxx.model.dao.IAdminDAO;
import org.xxx.model.dao.IDetailsDAO;
import org.xxx.model.dao.IGoodsDAO;
import org.xxx.model.dao.IUserDAO;
import org.xxx.model.dao.IOrderDAO;
import org.xxx.model.dao.IShopcarDAO;
import org.xxx.model.dao.implement.AdminDAO;
import org.xxx.model.dao.implement.GoodsDAO;
import org.xxx.model.dao.implement.UserDAO;
import org.xxx.model.dao.implement.OrderDAO;
import org.xxx.model.dao.implement.ShopcarDAO;
import org.xxx.model.dao.implement.DetailsDAO;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(Connection conn) {
        return new UserDAO(conn);
    }

    public static IAdminDAO getIAdminDAOInstance(Connection conn) {
        return new AdminDAO(conn);
    }

    public static IGoodsDAO getIGoodsDAOInstance(Connection conn) {
        return new GoodsDAO(conn);
    }

    public static IShopcarDAO getIShopcarDAOInstance(Connection conn) {
        return new ShopcarDAO(conn);
    }

    public static IOrderDAO getIOrderDAOInstance(Connection conn) {
        return new OrderDAO(conn);
    }
    
    public static IDetailsDAO getIDetailsDAOInstance(Connection conn) {
        return new DetailsDAO(conn);
    }
}

