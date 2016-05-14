package org.xxx.model.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentJson extends JsonMessage{
	List<Student> slist = new ArrayList<Student>();

	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}
	
}
