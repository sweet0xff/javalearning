package cn.mldn.oracle.util;

public class TestMD5Code {
	public static void main(String[] args) {
		String pass = "hello{admin}" ;
		System.out.println(new MD5Code().getMD5ofStr(pass));
	}
}
