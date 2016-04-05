package ThreadSocketTest;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by zeng on 16-4-5.
 */
public class ClientTest {

    public static void main(String[] agrs){

        Client  hehe = new Client();
    }
}

class Client{

    public Client(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket s =new  Socket(address,Server.SERVER_PORT);

            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Thread.sleep((int)(Math.random()*1000));//不定时随机向Server 发送消息
//            byte[] b = new byte[1024];
            out.writeUTF("客户端发来贺电");
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
