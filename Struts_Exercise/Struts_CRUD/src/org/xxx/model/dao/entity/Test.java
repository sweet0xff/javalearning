package org.xxx.model.dao.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String agrs[]){
		 String string = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		 Timestamp t = new Timestamp(90455476930L);
		 System.out.print(t);
		 
	}

}
