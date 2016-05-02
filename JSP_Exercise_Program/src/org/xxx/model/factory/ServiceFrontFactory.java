package org.xxx.model.factory;

import org.xxx.model.service.front.IUserServiceFront;
import org.xxx.model.service.front.implement.UserServiceFront;

public class ServiceFrontFactory {
	
	public static IUserServiceFront getIUserServiceFrontInstance(){
		return new UserServiceFront();
	}
	
}
