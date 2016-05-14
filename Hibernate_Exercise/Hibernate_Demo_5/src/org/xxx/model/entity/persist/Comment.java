package org.xxx.model.entity.persist;

import java.util.Date;

public class Comment {
	private Integer id;
	private String content;
	private Date postDate;
	private Blog blog;
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Comment(String content, Date postDate, Blog blog) {
		super();
		this.content = content;
		this.postDate = postDate;
		this.blog = blog;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
