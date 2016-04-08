package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		if(args.length !=2){ //如果初始化参数不是两位，则退出程序
			System.out.println("error!");
			System.exit(1);
			
		}

		File in = new File(args[0]); //第一个为源文件
		if(!in.exists()){
			System.out.println("源文件不存在");
			System.exit(1);
		}
		
		File out  = new File(args[1]);
		if(!out.getParentFile().exists()){
			out.getParentFile().createNewFile();
		}
		
		InputStream input = new FileInputStream(in);
		OutputStream output = new FileOutputStream(out);
		
		//实现文件拷贝
//		int temp = 0;
//		while((temp=in.read())!= -1){ //每次读取单个字节，速度慢
//			out.write(temp);
//		}
		
		int temp =0;
		byte [] data = new byte[1024];
		while((temp = input.read(data)) != -1){
			output.write(data, 0, temp); //时间较快
		}

		input.close();
		output.close();

		long end = System.currentTimeMillis();
		System.out.print("拷贝时间是： " + (end - start));

	}
}
