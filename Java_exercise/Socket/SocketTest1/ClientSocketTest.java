package SocketTest1;

import java.io.*;
import java.net.*;
/**
 * Created by Administrator on 2016/4/5.
 */
public class ClientSocketTest {
    public static void main(String [] agrs){
        Client client = new Client();
    }
}

class Client{
    public Client(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket s = new Socket(address,Server.SERVER_PORT);

            InputStream is = s.getInputStream();
            OutputStream out = s.getOutputStream();

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            PrintWriter pw = new PrintWriter(out,true);
            pw.println("你好，我是客户端");

            String ss= br.readLine();
            System.out.println(ss);

            pw.close();
            br.close();
            isr.close();
            out.close();
            is.close();
            s.close();
        }catch (UnknownHostException ue){
            ue.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
