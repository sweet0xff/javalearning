package org.xxx.util;
/**
 * 测试MD5类的功能是否正常
 * @author Zeng Ge
 *
 */
public class TestMD5Code {
	
	public static void main(String[] agrs){
		System.out.println(new MD5Code().getMD5ofStr("111"));
	}
}
