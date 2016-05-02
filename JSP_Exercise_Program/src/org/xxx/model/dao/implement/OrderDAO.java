package org.xxx.model.dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.xxx.model.dao.IOrderDAO;
import org.xxx.model.entity.User;
import org.xxx.model.entity.Order;

public class OrderDAO implements IOrderDAO {
	Connection conn= null;
	PreparedStatement pstmt = null;
	
    public OrderDAO(Connection conn) {
    	this.conn = conn;
    }

    @Override
    public boolean doCreate(Order vo) throws SQLException {
    	String sql_1 ="SELECT uname,phone,address FROM user where uid = ?";
        pstmt = conn.prepareStatement(sql_1);
        ResultSet rs_1 = pstmt.executeQuery();
        if(rs_1.next()){
        	User user = new User();
        	user.setUname(rs_1.getString("uname"));
        	user.setPhone(rs_1.getString("phone"));
        	user.setAddress(rs_1.getString("address"));
        }

    	String sql_2 = "INSERT INTO order(uname,phone,address,createtime,did,totalpay) VALUES (?,?,?,?,?)";
    	pstmt = conn.prepareStatement(sql_2);
    	ResultSet rs_2 = pstmt.executeQuery();
        if (rs_2.next()) {
        	pstmt.setString(2, vo.getUser().getUname());
        	pstmt.setString(3, vo.getUser().getPhone());
        	pstmt.setString(4, vo.getUser().getAddress());
        	pstmt.setDate(5, (Date) vo.getCreatedate());
        	pstmt.setInt(6, vo.getDid());
        	pstmt.setDouble(7, vo.getTotalpay());
        	return pstmt.executeUpdate() > 0;
        }
		return false;
    }


   @Override
    public boolean doDelete(Set<Integer> ids) throws SQLException {
        return false;
    }
    
    
    @Override
    public Order findById(Integer oid) throws SQLException {
        Order vo = new Order();
        String sql = "SELECT oid,uname,phone,address,createdate,did,totalpay FROM order WHERE oid = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, oid);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            vo = new Order();
            vo.setOid(rs.getInt("oid"));
            
            User user = new User();
            user.setUname(rs.getString("uname"));
            vo.setUser(user);
            
            vo.setUname(rs.getString("uname"));
            vo.setPhone(rs.getString("phone"));
            vo.setAddress(rs.getString("address"));
            vo.setCreatedate(rs.getDate("createdate"));
            vo.setTotalpay(rs.getDouble("totalpay"));
        }
        return vo;
    }
    
    @Override
    public List<Order> findAllByUserId(Integer uid, Integer curentPage, Integer lineSize) throws SQLException {
        List<Order> all = new ArrayList<Order>();
        String sql = "SELECT TOP ? FORM order WHERE oid NOT IN (SELECT TOP (? + '-1)' * ? ) oid FROM order "
        		+ "AND uid = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, curentPage);
        pstmt.setInt(2, curentPage);
        pstmt.setInt(3, lineSize);
        pstmt.setInt(4, uid);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Order vo = new Order();
            vo.setOid(rs.getInt("oid"));
            
            User user = new User();
            user.setUid(rs.getInt("uid"));
            user.setUname(rs.getString("uname"));
            vo.setUser(user);
            
            vo.setPhone(rs.getString("phone"));
            vo.setAddress(rs.getString("address"));
            vo.setCreatedate(rs.getDate("createdate"));
            vo.setTotalpay(rs.getDouble("totalpay"));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCountByUserId(Integer uid) throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders WHERE mid=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, uid);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
   
    @Override
    public boolean doUpdate(Order vo) throws SQLException {
        return false;
    }

 

    @Override
    public List<Order> findAll() throws SQLException {
        return null;
    }

	@Override
	public List<Order> findAllSplit(Integer currentPage, Integer lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findByOid(Integer uid, Integer oid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}

