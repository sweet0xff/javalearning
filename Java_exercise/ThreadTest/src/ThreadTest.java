/**
 * Created by Zeng on 2016/4/4.
 *
 */
public class ThreadTest { //主类

    public static void main(String[] agrs){
        myThread m1 = new myThread("yi");
        myThread m2 = new myThread("er");
        myThread m3 = new myThread("san");

//        m1.run();
//        m2.run();
//        m3.run();
        m1.start();
        m2.start();
        m3.start();
    }
}
class myThread extends Thread{
    private String name;
    public myThread(String name ){ //定义构造方法
        this.name = name;
    }
    public void run(){  //override run(),作为线程的主体操作方法
        for(int i = 0; i<5; i++){
            System.out.println(this.name + i);
        }
    }
}
