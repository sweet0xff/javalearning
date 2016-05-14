package org.xxx.web.action;

import java.util.HashMap;
import java.util.Map;

import org.xxx.model.entity.User;
import org.xxx.model.service.UserService;

public class LoginAction {
	private User user = new User();
	
	public User getUser() {
		return user;
	}
	private Map<String, Object> userJson = new HashMap<String,Object>();

	public Map<String, Object> getUserJson() {
		return userJson;
	}

	public void setUserJson(Map<String, Object> userJson) {
		this.userJson = userJson;
	}

	public String login() throws Exception{
		UserService service = new UserService();
		User returnUser = service.login(user);
		if(returnUser != null && returnUser.getName() !=null){
			User getUser = new User();
			getUser.setMessagecode(200);
			getUser.setMessageinfo("success");
			getUser.setName(returnUser.getName());
			getUser.setPassword(returnUser.getPassword());
			userJson.put("userinfo", getUser);
			
			return "success";
			
		}else {
			userJson.put("userinfo", returnUser);
			return "success";
		}
	}
}
