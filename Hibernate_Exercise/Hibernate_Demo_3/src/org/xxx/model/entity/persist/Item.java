package org.xxx.model.entity.persist;

import java.util.HashSet;
import java.util.Set;

public class Item {
	private Integer iid;
	private String iname;
	private Double basePrice;
	private Set<Category> categories = new HashSet<Category>();
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public Double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public Item(String iname, Double basePrice) {
		super();
		this.iname = iname;
		this.basePrice = basePrice;
	}
	
}
