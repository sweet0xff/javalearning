package CopyFile;

import java.net.*;
import java.io.*;

/**
 * Created by Administrator on 2016/4/5.
 */
public class CopyFieldServer {
    public static void main(String [] agrs){
	Server server = new Server;

    }
}
class Server{
    public static final int SERVER_PORT = 8888;
    public Server(){
        try {
            ServerSocket ss = new ServerSocket(SERVER_PORT);
            Socket s = ss.accept();

            InputStream in =s.getInputStream();
            FileOutputStream fo = new FileOutputStream("D:\\hehe.txt");

            byte[] b = new byte[1024];
            int len = -1;
            while (true){
                len  = in.read(b);

                if (len == -1){
                    break;
                }
                fo.write(b,0,len);
            }
            fo.close();
            in.close();
            s.close();
            ss.close();
        }catch (UnknownHostException ue){
            ue.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
