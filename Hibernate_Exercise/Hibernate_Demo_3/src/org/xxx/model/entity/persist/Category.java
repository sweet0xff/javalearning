package org.xxx.model.entity.persist;
import org.xxx.model.entity.persist.Item;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private Integer cid;
	private String cname;
	private Set<Item> items=new HashSet<Item>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String cname) {
		super();
		this.cname = cname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	

}
