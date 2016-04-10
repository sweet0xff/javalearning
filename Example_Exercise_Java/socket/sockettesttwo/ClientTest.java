package socket.sockettesttwo;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zeng on 16-4-10.
 */
public class ClientTest {
    public static void main(String[] args) throws Exception{
        Client client = new Client();
    }
}

class Client{
    public Client()throws Exception{
        Socket socket = new Socket("localhost",8889);

        Scanner scanner = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());

        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        scanner.useDelimiter("\n");

        while (true){
            System.out.println("please enter your message:");
            if(input.hasNext()){
                String  s = input.next().trim();
                out.println(s);
                if(s.equalsIgnoreCase("byebye")){
                    break;
                }
            }
            if(scanner.hasNext()){
                System.out.println(scanner.next());
            }
        }

        input.close();
        out.close();
        scanner.close();
        socket.close();

    }
}
