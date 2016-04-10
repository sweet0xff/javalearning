package socket.sockettestone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zeng on 16-4-10.
 */
public class ServerTest {
    public static void main(String[] args)throws Exception {
        Server server = new Server();
    }
}
class Server{
    public static final int SERVER_PORT = 9999; // 设置端口.
    public Server()throws Exception{
        ServerSocket ss = new ServerSocket(SERVER_PORT);
        System.out.println("等待客户端连接......");
        Socket s = ss.accept();
        System.out.println("客户端已连上");

        //OutputStream并不方便进行打印流的输出，所以利用PrintStream输出.
        PrintStream out = new PrintStream(s.getOutputStream());

        out.println("hello ,world .hello ,Java");

        out.close();
        s.close();
        ss.close();
    }
}
