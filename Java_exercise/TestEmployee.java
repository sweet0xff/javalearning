import java.util.*;

/**
 * This program shows a test about the class.
 * source : 《Java核心技术》第一卷
 *
 * Created by Zeng Ge on 2016/3/22.
 */
public class TestEmployee {

    public static void main(String[] agrs) {
        //fill the staff array with three Empolyee object
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("zhangsan", 75000, 1987, 12, 15);
        staff[1] = new Employee("lisi", 5000, 1989, 12, 15);
        staff[2] = new Employee("wangwu", 40000, 1977, 10, 13);

        //raise salary by 5 percent
        for (Employee e : staff)
            e.raiseSalary(5);

        //print out information about the Employee
        for (Employee e : staff)
            System.out.println("name = " + e.getName() + " salary = " + e.getSalary() + " hireDay = " + e.getHireDay());
    }
}

class Employee{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n,double s,int year,int month,int day){
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        hireDay = calendar.getTime();
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public Date getHireDay(){
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent/100;
        salary += raise;
    }
}


