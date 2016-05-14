package org.xxx.model.service.impl;

import java.util.List;

import org.xxx.factory.DAOFactory;
import org.xxx.model.dao.BaseDAO;
import org.xxx.model.dao.entity.Student;
import org.xxx.model.service.IStudentService;

public class StudentService implements IStudentService {
	BaseDAO dao = new BaseDAO();

	@Override
	public boolean creat(Student vo) throws Exception {
		try {
			return DAOFactory.getIStudentDAOInstance(this.dao.getConnection()).doCreat(vo);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dao.closeAll();
		}
	}

	@Override
	public boolean delete(String sname) throws Exception {
		try {
			return DAOFactory.getIStudentDAOInstance(this.dao.getConnection()).doDelete(sname);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dao.closeAll();
		}
	}

	@Override
	public boolean update(Student vo) throws Exception {
		try{
			return DAOFactory.getIStudentDAOInstance(this.dao.getConnection()).doUpdate(vo);
		}catch(Exception e){
			throw e;
		}finally{
			this.dao.closeAll();
		}
	}

	@Override
	public List<Student> find() throws Exception {

		try{
			return DAOFactory.getIStudentDAOInstance(this.dao.getConnection()).doFindAll();
		}catch(Exception e){
			throw e;
		}finally {
			this.dao.closeAll();
		}
	}

}
