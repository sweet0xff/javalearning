package IOExample;

import java.io.*;

/**
 * int read(),返回值是int类型, 读到结尾时返回-1
 * int read(byte[] b ).
 * int read(byte[] b ,int off ,int len)
 * Created by Zeng on 2016/4/7.
 */
public class InPutStreamTest{

    public static void main(String[] agrs)throws IOException{
        File f = new File("D:" + File.separator + "Demo" +File.separator + "demo.txt");
//        if(f.exists()){
            //使用InPutStream类进行读取,InPutStream是抽象类,既要用其子类FileInputStream来对父类进行实例化
//            InputStream input = new FileInputStream(f);
//            byte[] data = new byte[1024];
//
//            int len =  input.read(data); //将内容保存到字节数组中,同时记录数据长度
//            System.out.println("[" + new String(data,0,len) + "]");
//            input.close();
//        }

        //input.read()每次只读取一个字节,下面是用while循环读取,重点掌握
        if(f.exists()){
            InputStream in = new FileInputStream(f);
            byte[] data = new byte[1024];
            int foot = 0;
            int temp = 0 ;
            while ((temp = in.read())!= -1){
                data[foot ++] = (byte)temp; //要把temp转换成byte类型
            }
            in.close();

            System.out.println("[" + new String(data,0,foot) + "]");
        }



    }
}
