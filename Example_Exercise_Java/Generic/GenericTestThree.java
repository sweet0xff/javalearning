package Generic;

/**
 * Created by zeng on 16-4-9.
 */

public class GenericTestThree {

    public static void main(String[] args) {
        Messagehehe<Integer> m = new Messagehehe();
        m.setMsg(843490);
//        fun(m);  /引用传递
    }

    public static void fun(Message<?> temp) { //?是通配符.

//        temp.setMsg("hehe");//不能设置，只能取出
        System.out.println(temp.getMsg());

    }
}

class Messagehehe<T>{
    private T msg;
    public void setMsg(T msg){
        this.msg = msg;
    }
    public T getMsg(){
        return msg;
    }
}