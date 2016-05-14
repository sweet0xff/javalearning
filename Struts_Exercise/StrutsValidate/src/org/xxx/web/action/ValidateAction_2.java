package org.xxx.web.action;

import javax.security.auth.login.LoginContext;

import com.opensymphony.xwork2.ActionSupport;

public class ValidateAction_2 extends ActionSupport{
	private String account;
	private String password;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String login(){
		return "success";
	}
	
	public void validateLogin() {

		String emailRegex = "\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b";
		if(!account.matches(emailRegex)){
			addFieldError("account", "邮箱格式不正确");
		}
	}
	
}
