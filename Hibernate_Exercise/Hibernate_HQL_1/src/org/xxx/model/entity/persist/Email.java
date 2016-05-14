package org.xxx.model.entity.persist;

/**
 * Email entity. @author MyEclipse Persistence Tools
 */

public class Email implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String eaddress;

	// Constructors

	/** default constructor */
	public Email() {
	}

	/** full constructor */
	public Email(String eaddress) {
		this.eaddress = eaddress;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEaddress() {
		return this.eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

}