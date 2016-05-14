package org.xxx.model.entity.persist;

import java.util.HashSet;
import java.util.Set;

/**
 * Classtype entity. @author MyEclipse Persistence Tools
 */

public class Classtype implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cname;
	private Set studentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classtype() {
	}

	/** full constructor */
	public Classtype(String cname, Set studentses) {
		this.cname = cname;
		this.studentses = studentses;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getStudentses() {
		return this.studentses;
	}

	public void setStudentses(Set studentses) {
		this.studentses = studentses;
	}

}