package org.xxx.model.service.impl;

import java.util.List;

import org.xxx.model.dao.ClasstypeDAO;
import org.xxx.model.entity.persist.Classtype;
import org.xxx.model.service.ClasstypeService;

public class ClasstypeServiceImpl implements ClasstypeService{
	private ClasstypeDAO ClasstypeDAO;

	public ClasstypeDAO getClasstypeDAO() {
		return ClasstypeDAO;
	}

	public void setClasstypeDAO(ClasstypeDAO classtypeDAO) {
		ClasstypeDAO = classtypeDAO;
	}

	@Override
	public List<Classtype> findAllClasstype() {
		return ClasstypeDAO.doFindAlClasstype();
	}

}
