package Generic;

/**
 * 泛型接口的第二种使用形式.
 * Created by zeng on 16-4-9.
 */

interface IMage<T>{
    public void print(T t);
}

class IMss implements IMage<String>{
    public void print(String s){
        System.out.println(s);
    }
}

public class GenericTestFive{
    public static void main(String[] args) {
        IMss hehe = new IMss();
        hehe.print("hello world,hello ,Java");
    }

}
