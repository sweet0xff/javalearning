package ThreadSocketTest;

import com.sun.deploy.util.SessionState;

import java.io.*;
import java.net.*;

/**
 * Created by zeng on 16-4-5.
 */
public class ServerTest {

    public static void main(String[] agrs){
        Server sss = new Server();
    }
}

class Server{
    private static final int SERVER_PORT = 8888;
    public Server(){
        try {
            ServerSocket ss = new ServerSocket(SERVER_PORT);

            int i = 0;
            while(true){  //创建一个死循环，监听请求
                Socket s = ss.accept();
                i ++;
                System.out.println("第" + i + "个监听创建成功");

                ClientThread ct = new ClientThread(i,s); //创建客户端线程处理的对象
                Thread t  = new Thread(ct); //创建客户端处理线程
                t.start();  //start thread
            }
        }catch (UnknownHostException ue){
            ue.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ClientThread{
    int ClientIndex = 0; // save id of client
    Socket s = null; //保存客户端Socket 对象

    public ClientThread(int i , Socket s){
        this.ClientIndex = i;
        this.s = s;
    }

    public void run(){
        try {
            DataInputStream is = new DataInputStream(s.getInputStream());
            System.out.println("第"+ ClientIndex + "个客户端发送消息 " + is.readUTF());
            is.close();
            s.close();

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
