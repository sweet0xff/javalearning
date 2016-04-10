package Generic;

/**
 * Created by zeng on 16-4-9.
 */
public class GenericTestOne {
    public static void main(String[] args) {
        Point<String> p = new Point<String>();  //只能是引用类型，不能是基本类型
        p.setX("东经12度");
        System.out.println(p.getX());

        Point<Integer> pl = new Point<Integer>();
        pl.setX(10);  //包装类的自动装箱功能.
        System.out.println(pl.getX());

        //如果没哟指定类型，则用Object操作.
        //Point p = new Point();
    }
}

//此时设置的T在Point类上只表示一个标记，在使用时要为其设置具体的类型
class Point<T>{  //定义了一个二维坐标,由Point使用时动态指定
    private T x;
    private T y;

    public void setY(T y) {
        this.y = y;
    }

    public T getY() {
        return y;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

}
