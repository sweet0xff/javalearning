package org.xxx.model.service.back.implement;
import org.xxx.model.dao.implement.BaseDao;
import org.xxx.model.entity.Admin;
import org.xxx.model.factory.DAOFactory;
import org.xxx.model.service.back.IAdminService;

public class AdminService implements IAdminService {
    private BaseDao dbc = new BaseDao();

    @Override
    public boolean login(Admin vo) throws Exception {
        try {
            return DAOFactory.getIAdminDAOInstance(this.dbc.getConnection()).findLogin(vo) ;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
