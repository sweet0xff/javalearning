package org.xxx.web.action;

import org.xxx.model.entity.User;

import com.opensymphony.xwork2.ModelDriven;


public class DemoAction_3 implements ModelDriven<User> {
	//模型驱动
	private  User user=new User();
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute(){
		if("admin".equals(user.getName())&&"111".equals(user.getPassword())){
			message="这么NB，这都会玩！";
			return "success";
		}else {
			message="骚年，继续努力。。。";
			return "sorry";
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
