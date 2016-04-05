package InetAddressTest;

import java.net.*;

/**
 * InetAddress 方法练习.
 * Created by Zeng on 2016/4/5.
 */
public class InetAddressTest {

    public static void main(String[] agrs)throws UnknownHostException{
        InetAddress[] a = InetAddress.getAllByName("www.163.com");
        for(InetAddress ad :a){
            System.out.println(ad);
        }

        InetAddress b = InetAddress.getLocalHost();
        System.out.println(b);

//        InetAddress[] c = InetAddress.getByAddress("61.136.167.33");
    }
}
