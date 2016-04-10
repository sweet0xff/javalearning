package socket.sockettesttwo;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zeng on 16-4-10.
 */
public class ServerTest {
    public static void main(String[] args) throws Exception{
        Server server = new Server();

    }
}
class Server{
//    public static final int SERVER_PORT = 8888;
    public Server()throws Exception{

        ServerSocket ss = new ServerSocket(8889);
        Socket s = ss.accept();
        System.out.println("连接已建立！");
        Scanner scanner  = new Scanner(s.getInputStream());
        PrintStream out = new PrintStream(s.getOutputStream());

        scanner.useDelimiter("\n");

        while (true){
            if(scanner.hasNext()){
                String str = scanner.next().trim();
                if(str.equalsIgnoreCase("byebye")){
                    out.println("byebye");
                    break;
                }else {
                    out.println("ECHO :" + str);
                }
            }
        }

        out.close();
        scanner.close();
        s.close();
        ss.close();



    }
}
