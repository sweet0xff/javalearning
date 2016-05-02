package org.xxx.model.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid; // �û�ID
	private String uaccount; //�û���¼��
    private String upassword; //�û�����
    private String uname; // �û�����
    private String phone;//��ϵ�绰
    private String address; // ��ϵ��ַ
    private List<Order> allOrders;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Order> getAllOrders() {
		return allOrders;
	}
	public void setAllOrders(List<Order> allOrders) {
		this.allOrders = allOrders;
	}

	
}	
