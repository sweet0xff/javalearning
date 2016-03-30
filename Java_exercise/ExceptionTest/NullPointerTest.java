/**
 * NullPointerExcepiton test.
 * Created by Zeng Ge on 2016/3/30.
 */
public class NullPointerTest {

    public static void main(String[] agrs){
        try {
            Student st = new Student();
            st = null;
            System.out.print(st.getAge());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}

class Student{
    String name;
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    int age;
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
