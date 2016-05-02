package org.xxx.model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.xxx.model.dao.IDetailsDAO;
import org.xxx.model.entity.Details;
import org.xxx.model.entity.Goods;
import org.xxx.model.entity.Order;

public class DetailsDAO implements IDetailsDAO {
	Connection conn= null;
	PreparedStatement pstmt = null;
	
	public DetailsDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Details vo) throws Exception {
		return false;
	}

	@Override
	public boolean doUpdate(Details vo) throws Exception {
		return false;
	}

	@Override
	public Details findById(Integer id) throws Exception {
		return null;
	}

	@Override
	public List<Details> findAll() throws Exception {
		return null;
	}
	
	@Override
	public List<Details> findAllSplit(Integer currentPage, Integer lineSize)
			throws Exception {
		return null;
	}

	

	@Override
	public List<Details> findAllByOrders(Integer oid) throws Exception {
        List<Details> all = new ArrayList<Details>();
        String sql = "SELECT did,oid,gid,amount price FROM details WHERE oid=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, oid);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Details vo = new Details();
            vo.setDid(rs.getInt(1));

            Order order = new Order();
            order.setOid(rs.getInt("oid"));
            vo.setOrder(order);

            Goods goods = new Goods();
            goods.setGid(rs.getInt("gid"));
            vo.setGoods(goods);
            vo.setPrice(rs.getDouble("price"));
            vo.setAmount(rs.getInt("amount"));
            all.add(vo);
        }
        return all;
    }

	@Override
	public boolean doDelete(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
