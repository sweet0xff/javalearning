package org.xxx.model.service.impl;

import java.util.List;

import org.springframework.dao.support.DaoSupport;
import org.xxx.model.dao.StudentsDAO;
import org.xxx.model.entity.persist.Students;
import org.xxx.model.entity.persist.StudentsClasstype;
import org.xxx.model.service.StudentsService;

public class StudentsServiceImpl implements StudentsService {
	private StudentsDAO studentsDAO;

	public StudentsDAO getStudentsDAO() {
		return studentsDAO;
	}

	public void setStudentsDAO(StudentsDAO studentsDAO) {
		this.studentsDAO = studentsDAO;
	}

	@Override
	public List<StudentsClasstype> findAllStudents() {
		return studentsDAO.doFindAllStudents();
	}

	@Override
	public Students findStudentsById(Integer sid) {

		return studentsDAO.doFindStudentsById(sid);
	}

	@Override
	public boolean updateStudents(Students vo) {
		return studentsDAO.doUpdateStudents(vo);
	}

	@Override
	public boolean addStudents(Students vo) {
		try {
			studentsDAO.save(vo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//	@Override
//	public boolean deleteStudents(Integer sid) {
//		return studentsDAO.doDelete(sid);
//	}

	@Override
	public boolean delete(Students vo) {
		try {
			studentsDAO.delete(vo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	

}
