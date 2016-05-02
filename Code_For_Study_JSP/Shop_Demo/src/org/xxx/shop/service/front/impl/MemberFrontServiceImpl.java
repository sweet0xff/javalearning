package cn.mldn.shop.service.front.impl;

import cn.mldn.shop.dbc.DatabaseConnection;
import cn.mldn.shop.factory.DAOFactory;
import cn.mldn.shop.service.front.IMemberServiceFront;
import cn.mldn.shop.vo.Member;

public class MemberFrontServiceImpl implements IMemberServiceFront {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean regist(Member vo) throws Exception {
        try {
            if (DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findById(vo.getMid()) == null) {
                return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).doCreate(vo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
        return false;
    }

    @Override
    public boolean active(Member vo) throws Exception {
        try {
            if (DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findByCode(vo.getMid(), vo.getCode())) {
                return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).doUpdateStatus(vo.getMid(), 1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
        return false;
    }

    @Override
    public boolean login(Member vo) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findLogin(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Member updatePre(String mid) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findById(mid);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Member vo) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).doUpdateByMember(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
