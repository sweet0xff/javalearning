package org.xxx.web.action;

import org.xxx.model.entity.User;

import com.opensymphony.xwork2.ModelDriven;


public class DemoAction_3 implements ModelDriven<User> {
	//ģ������
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
			message="��ôNB���ⶼ���棡";
			return "success";
		}else {
			message="ɧ�꣬����Ŭ��������";
			return "sorry";
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
