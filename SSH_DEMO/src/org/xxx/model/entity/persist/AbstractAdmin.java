package org.xxx.model.entity.persist;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractAdmin entity provides the base persistence definition of the Admin
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractAdmin implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String aname;
	private String apassword;

	// Constructors

	/** default constructor */
	public AbstractAdmin() {
	}

	/** full constructor */
	public AbstractAdmin(String aname, String apassword) {
		this.aname = aname;
		this.apassword = apassword;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "aname", length = 32)
	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Column(name = "apassword", length = 32)
	public String getApassword() {
		return this.apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

}