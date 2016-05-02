package org.xxx.model.entity;

import java.util.ArrayList;
import java.util.List;

public class UserJson extends JsonMessage {
	private List<User> ulist = new ArrayList<User>();

	public List<User> getUlist() {
		return ulist;
	}

	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}
	

}
