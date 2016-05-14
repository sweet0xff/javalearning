package org.xxx.web.action;

import org.xxx.model.entity.User;

public class DemoAction_2 {
	//属性驱动模型 
	private User user = new User();
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;
	
	public String execute(){
		if("admin".equals(user.getName())&&("111").equals(user.getPassword())){
			message = "账号和密码正确";
			return "success";
		}else {
			message="sorry,error";
			return "error";
		}
	}

}
