package org.xxx.model.entity.persist;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "classtype", catalog = "test")
public class Classtype extends AbstractClasstype implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Classtype() {
	}

	/** full constructor */
	public Classtype(String cname, Set<Students> studentses) {
		super(cname, studentses);
	}

}
