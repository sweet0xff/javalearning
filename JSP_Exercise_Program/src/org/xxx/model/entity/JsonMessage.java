package org.xxx.model.entity;

public class JsonMessage {
	private Integer messageCode = 202;
	private String messageInfo = "fail";
	private Integer count = 0 ;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(Integer messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageInfo() {
		return messageInfo;
	}
	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}
	

}
