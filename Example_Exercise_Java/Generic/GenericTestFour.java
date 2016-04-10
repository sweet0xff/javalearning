package Generic;

import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.T;

/**
 * 泛型接口的两种使用形式.
 * Created by zeng on 16-4-9.
 */
interface IMessage<T>{ //设置泛型接口
    public void print(T t);
}
//在子类中继续使用泛型，并且接口和子类使用同样的泛型标记
class MessageImpl<T> implements IMessage<T>{
    public void print(T t){
        System.out.println(t);
    }
}
public class GenericTestFour {

    public static void main(String[] args) {
       MessageImpl<String>  msge = new MessageImpl<String>();
        msge.print("hello Java");
    }
}
