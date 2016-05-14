package org.xxx.model.service;

import java.util.List;

import org.xxx.model.dao.ClasstypeDAO;
import org.xxx.model.entity.persist.Classtype;

public class ClasstypeService {
	
	ClasstypeDAO dao = new ClasstypeDAO();
	
	public List<Classtype> findAllClasstypes(){
		return dao.doFindAll();
	}

}
