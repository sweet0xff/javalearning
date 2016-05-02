package cn.mldn.shop.service.back.impl;

import cn.mldn.shop.dbc.DatabaseConnection;
import cn.mldn.shop.factory.DAOFactory;
import cn.mldn.shop.factory.ServiceFrontFactory;
import cn.mldn.shop.service.back.IMemberServiceBack;
import cn.mldn.shop.vo.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemberServiceBackImpl implements IMemberServiceBack {

    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allMembers", DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findAll(column, keyWord, currentPage, lineSize));
            map.put("allCount", DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).getAllCount(column, keyWord));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listByStatus(int status, String column, String keyWord, int currentPage, int lineSize) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allMembers", DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findByStatus(status, column, keyWord, currentPage, lineSize));
            map.put("allCount", DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).getAllCountByStatus(status, column, keyWord));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updateActive(Set<String> ids) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).doUpdateByStatus(ids,1);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updateLock(Set<String> ids) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).doUpdateByStatus(ids,0);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Member show(String id) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findById(id);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }
}
