package SocketTest;

import java.io.*;
import java.net.*;
/**
 * Socket练习,字节流.
 * Created by Zeng on 2016/4/5.
 */
public class ClientSocketTest {

    public static void main(String[] agrs){
        Client haha = new Client();
    }
}

class Client{
//    public static final int SERVER_PORT = 8888;
    public Client(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket cs = new Socket(address,Server.SERVER_PORT);
            System.out.println("客户端已启动");

            InputStream in = cs.getInputStream();
            OutputStream out = cs.getOutputStream();

            String toServerString = "你好。我是客户端";
            out.write(toServerString.getBytes());

            byte[] buf = new byte[1024];
            int len = in.read(buf);
            in.read(buf);
            String sFromServer = new String(buf,0,len);
            System.out.print("来自服务器的回答：");
            System.out.println(sFromServer);

            in.close();
            out.close();
            cs.close();

        }catch (UnknownHostException e ){
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
