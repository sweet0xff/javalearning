package socket.sockettestone;

import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zeng on 16-4-10.
 */
public class ClientTest {
    public static void main(String[] args)throws Exception {
        Client client = new Client();
    }
}

class Client{
    public Client()throws Exception{
//        InetAddress address = InetAddress.getLocalHost();
        Socket s = new Socket("localhost",Server.SERVER_PORT);  //连接服务器.

        Scanner in = new Scanner(s.getInputStream());
        in.useDelimiter("\n");
        if(in.hasNext()){
            System.out.println("回应数据 : " + in.next());
        }

        in.close();
        s.close();

    }

}
