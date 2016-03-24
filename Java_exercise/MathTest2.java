/**
 * Math类的练习.
 * Created by Zeng Ge  on 2016/3/24.
 */
public class MathTest2 {

    public static void main(String[] agrs) {
        Student s1 = new Student("Andy",18);
        Student s2 = new Student("Jacky",18);

        System.out.println(s1.equals(s2));
        System.out.println(s1.getClass());
    }
}

class Student{
    private String name;
    private int age;

    public Student(String name ,int age){
        this.name = name ;
        this.age = age;
    }

    public boolean equals(Student input){
        if(input.age == age){
            return true;
        }else {
            return false;
        }
    }
}

