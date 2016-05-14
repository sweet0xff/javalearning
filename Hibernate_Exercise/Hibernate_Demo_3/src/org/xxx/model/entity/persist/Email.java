package org.xxx.model.entity.persist;

public class Email {
	private Integer eid;
	private String eaddress;
	private Customer customer;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Email(String eaddress) {
		super();
		this.eaddress = eaddress;
	}
	public Email() {
		super();
	}
	

}
