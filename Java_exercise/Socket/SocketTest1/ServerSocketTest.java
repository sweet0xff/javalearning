package SocketTest1;

import java.net.*;
import java.io.*;
/**
 * Created by Zeng on 2016/4/5.
 */
public class ServerSocketTest {

    public static void main(String[] agrs){
        Server server= new Server();
    }
}

class Server{
    public static final int SERVER_PORT = 9999;
    public Server(){
        try{
            ServerSocket ss = new ServerSocket(SERVER_PORT);

            Socket s = ss.accept();

            InputStream is = s.getInputStream();
            OutputStream out = s.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String sss = br.readLine();
            System.out.println(sss);

            PrintWriter pw= new PrintWriter(out);
            pw.print("hello,我是服务器。");

            pw.close();
            br.close();
            isr.close();
            out.close();
            is.close();
            s.close();
            ss.close();
        }catch (UnknownHostException ue){
            ue.printStackTrace();
        }catch (IOException oe){
            oe.printStackTrace();
        }
    }

}
