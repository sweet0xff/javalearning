package TestThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/6.
 */
public class ServerTest {

    public static void main(String[] agrs){
        Server he = new Server();

    }
}

class Server{
    public static final int SERVER_PORT = 8888;
    public Server(){
        try {
            ServerSocket ss = new ServerSocket(SERVER_PORT);
            int i  = 0;

            while (true){
                Socket s = ss.accept();
                i ++;
                System.out.println("第" + i + "个建立连接成功。");
                ServerThread ct = new ServerThread(i,s);
                Thread t = new Thread(ct);
                t.start();

            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

class ServerThread implements Runnable{
    int count;
    Socket cs =  null;

    public ServerThread(int count, Socket s){
        this.count = count;
        this.cs = s;
    }

    public void  run(){
        try {
            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String ssss = br.readLine();
            System.out.println("第" + count + "个客户端发来贺电：" + ssss);

            br.close();
            isr.close();
            is.close();
            cs.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

