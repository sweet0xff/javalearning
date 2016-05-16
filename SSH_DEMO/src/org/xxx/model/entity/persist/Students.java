package org.xxx.model.entity.persist;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "students", catalog = "test")
public class Students extends AbstractStudents implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Students() {
	}

	/** full constructor */
	public Students(Classtype classtype, String sname, String ssex) {
		super(classtype, sname, ssex);
	}

}
