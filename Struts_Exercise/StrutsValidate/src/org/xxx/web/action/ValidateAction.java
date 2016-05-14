package org.xxx.web.action;


import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ValidateAction extends ActionSupport{
	
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
	
	public String execute(){
		return "success";
	}
	@Override
	public void validate() {
		if(account.length() < 5){
			this.addFieldError("account", "账号长度必在6到12位之间");
		}
		if(password.length() < 5){
			this.addFieldError("password", "密码必在6到12位之间" );
		}

	}

}
