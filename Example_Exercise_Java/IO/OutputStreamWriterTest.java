package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 实现字节流到字符流的转换
 * 
 * @author Zeng 
 *
 */
public class OutputStreamWriterTest {

	public static void main(String[] args) throws IOException {
		File f = new File("E:" + File.separator + "Demo" + File.separator + "test.txt");
		if(!f.getParentFile().exists()){
			f.getParentFile().mkdirs();
		}
		if(!f.exists()){
			f.createNewFile();
		}
		OutputStream out = new FileOutputStream(f);
		//将OutputStream类对象传递给OutputStreamWriter的构造方法
		Writer w = new OutputStreamWriter(out);
		w.write("hello , Java.nihao ,Java");
		w.close();
		out.close();
	}

}
