package org.xxx.web.action;

import java.text.SimpleDateFormat;

public class FirstDemoAction {
	private String time ;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String execute(){
	    time = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new java.util.Date());
		
		return "success";
	}
	
}
