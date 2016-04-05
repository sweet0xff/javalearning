package SocketTest;
import java.io.*;
import java.net.*;

/**
 * socket练习.字节流.
 * Created by Zeng on 2016/4/5.
 */
public class ServerSocketTest {

    public static void main(String[] agrs) {
        Server hehe  = new Server();
    }
}

class Server{
    public static final int SERVER_PORT = 8888;
    public Server(){
        try {
            ServerSocket ss = new ServerSocket(SERVER_PORT);
            System.out.println("服务器端已启动，等待客户端请求中......");
            Socket s = ss.accept();

            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            byte[] buf = new byte[1024];

            int len = in.read(buf);
            String sFromClient = new String(buf,0,len);
            System.out.print("来自客户端的的问话：");
            System.out.println(sFromClient);

            String tClient = "客户端你好！";
            out.write(tClient.getBytes());
            in.close();
            out.close();
            s.close();
            ss.close();


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
