package org.xxx.model.entity.persist;
import org.xxx.model.entity.persist.Item;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private Integer cid;
	private String cname;
	
	private Set<categoryItem> categoryItems = new HashSet<categoryItem>();

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<categoryItem> getCategoryItems() {
		return categoryItems;
	}

	public void setCategoryItems(Set<categoryItem> categoryItems) {
		this.categoryItems = categoryItems;
	}
	
}
