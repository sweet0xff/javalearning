package org.xxx.model.entity.persist;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Blog {
	private Integer id;
	private String tittle;
	private String content;
	private Date creat_time;
	private String type;
	private Set<Comment> comments = new HashSet<Comment>();
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Blog(String tittle, String content, Date creat_time, String type) {
		super();
		this.tittle = tittle;
		this.content = content;
		this.creat_time = creat_time;
		this.type = type;
	}
	public Blog() {
		super();
	}
	

}
