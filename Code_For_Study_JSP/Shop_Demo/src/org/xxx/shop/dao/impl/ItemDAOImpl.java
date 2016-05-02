package cn.mldn.shop.dao.impl;

import cn.mldn.shop.dao.IItemDAO;
import cn.mldn.shop.vo.Item;
import cn.mldn.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ItemDAOImpl extends AbstractDAOImpl implements IItemDAO {

    public ItemDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Item vo) throws SQLException {
        String sql = " INSERT INTO item (title) VALUES (?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getTitle());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Item vo) throws SQLException {
        String sql = " UPDATE item SET title=? WHERE iid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getTitle());
        super.pstmt.setInt(2, vo.getIid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
        return super.removeHandle("item","iid",ids);
    }


    @Override
    public Item findById(Integer id) throws SQLException {
        Item vo = null;
        String sql = " SELECT iid,title FROM item WHERE iid=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo = new Item();
            vo.setIid(rs.getInt(1));
            vo.setTitle(rs.getString(2));
        }
        return vo;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> all = new ArrayList<>();
        String sql = " SELECT iid ,title FROM item ";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            Item vo = new Item();
            vo.setIid(rs.getInt(1));
            vo.setTitle(rs.getString(2));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Item> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
