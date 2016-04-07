package TestThread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 利用线程处理Socket通信，实现客户端不停请求服务器端，服务器端不停响应客户端的功能.
 * Created by Zeng on 2016/4/6.
 */
public class ClientTest {

    public static void main(String[] agrs){
        Client haha = new Client();
    }
}

class Client{
    public Client(){

        while (true){
            ClientThread c = new ClientThread();
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
           Thread t = new Thread(c);
            t.start();
        }
    }

}

class ClientThread implements Runnable{

    public void run(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket s = new Socket(address,Server.SERVER_PORT);

            OutputStream out = s.getOutputStream();
            PrintWriter pw = new PrintWriter(out,true);
            Thread.sleep((int)(Math.random()*3000));

            pw.println("hello Java");

            pw.close();
            out.close();
            s.close();

        }catch (UnknownHostException ue){
            ue.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }
}
