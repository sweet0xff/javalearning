package Generic;

/**
 * 通配符的使用.
 * ?extends类：设置泛型上限，可以在申明上和方法上使用
 * ex: ?extends Number，意味着可以设置Number或者Number的子类(Integer, Double等)
 * ？super类：设置泛型下限，在方法参数上使用.
 * ex:?super String,意味着只能设置String 或者String的父类Object.
 * Created by zeng on 16-4-9.
 */
public class GenericTestTwo {

    public static void main(String[] args) {
        Message<Integer> m = new Message<Integer>();
        m.setMsg(11);
        fun(m);  //引用传递
    }

    public static void fun(Message<? extends Number> temp) { //?是通配符.
        System.out.println(temp.getMsg());

    }
}

class Message<T extends Number>{
    private T msg;
    public void setMsg(T msg){
        this.msg = msg;
    }
    public T getMsg(){
        return msg;
    }
}
