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
		if(args.length !=2){ //�����ʼ������������λ�����˳�����
			System.out.println("error!");
			System.exit(1);
			
		}

		File in = new File(args[0]); //��һ��ΪԴ�ļ�
		if(!in.exists()){
			System.out.println("Դ�ļ�������");
			System.exit(1);
		}
		
		File out  = new File(args[1]);
		if(!out.getParentFile().exists()){
			out.getParentFile().createNewFile();
		}
		
		InputStream input = new FileInputStream(in);
		OutputStream output = new FileOutputStream(out);
		
		//ʵ���ļ�����
//		int temp = 0;
//		while((temp=in.read())!= -1){ //ÿ�ζ�ȡ�����ֽڣ��ٶ���
//			out.write(temp);
//		}
		
		int temp =0;
		byte [] data = new byte[1024];
		while((temp = input.read(data)) != -1){
			output.write(data, 0, temp); //ʱ��Ͽ�
		}

		input.close();
		output.close();

		long end = System.currentTimeMillis();
		System.out.print("����ʱ���ǣ� " + (end - start));

	}
}
