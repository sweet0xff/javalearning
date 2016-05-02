package org.xxx.model.entity;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer iid;
	private String title;
	private List<Goods> allGoods;
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	 
	
}
