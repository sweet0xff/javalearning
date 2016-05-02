package org.xxx.model.entity;

import java.io.Serializable;
import java.util.List;

public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String aid;
    private String aname;
    private String apassword;

    public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public List<Goods> getAllGoods() {
		return allGoods;
	}
	public void setAllGoods(List<Goods> allGoods) {
		this.allGoods = allGoods;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private List<Goods> allGoods;

}
