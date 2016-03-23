/**
 * This programe demonstrate static methods.
 * source:《Java核心技术》卷一.
 * Created by Administrator on 2016/3/23.
 */
public class StaticTest {

    public static  void main(String[] agrs){
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom",4000);
        staff[1] = new Employee("Loff",5000);
        staff[2] = new Employee("Herry",6000);

        // The result is:
        //name =Tom,id=1,salary = 4000.0
        //name =Loff,id=2,salary = 5000.0
        //name =Herry,id=3,salary = 6000.0
        //Next avaliable id = 4
        for(Employee e :staff) {
            e.setId();
            System.out.println("name =" +e.getName() + ",id=" + e.getId() + ",salary = " + e.getSalary());
        }

        int n = Employee.getNextId();
        System.out.println("Next avaliable id = " + n);
    }
}

class Employee{
    private static int nextId = 1;

    private String name;
    private double salary;
    private int  id;

    public Employee(String n,double s){
        name = n;
        salary = s;
        id = 0;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return  salary;
    }

    public int getId(){
        return id;
    }

    public void setId(){
        id = nextId;
        nextId++;
    }

    public static int getNextId(){
        return nextId;
    }
}
