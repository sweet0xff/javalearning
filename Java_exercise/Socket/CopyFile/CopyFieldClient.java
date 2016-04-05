package CopyFile;

import java.net.*;
import java.io.*;

/**
 * Created by Administrator on 2016/4/5.
 */
public class CopyFieldClient {
    public static void main(String [] agrs){

    }
}
class Client{
    public Client(){
       try {
           InetAddress address =InetAddress.getLocalHost();
           Socket s = new Socket(address,Server.SERVER_PORT);

           OutputStream out = s.getOutputStream();
           FileInputStream fo = new FileInputStream("C:\\logdata.txt");

           byte[] b = new byte[1024];
           int len =-1;
           while ((len = fo.read(b)) > 0 ){
               out.write(b, 0 ,len);
           }
           fo.close();
           out.close();
           s.close();

       }catch (IOException e){
           e.printStackTrace();
       }finally {
           System.out.print("Client is over");
       }
    }
}
