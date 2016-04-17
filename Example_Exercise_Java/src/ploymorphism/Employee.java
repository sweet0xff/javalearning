package ploymorphism;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 多态的实现.
 * Created by Zeng on 2016/4/12.
 */

public class Employee{
    private String name;
    private double salary;
    private Date hireday;

    public Employee(String name,double salary,int year,int month,int day){
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        this.hireday= calendar.getTime();
    }

    public void setHireday(Date hireday) {
        this.hireday = hireday;
    }

    public void setSalary(double salary) {

        this.salary = salary;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Date getHireday() {

        return hireday;
    }

    public double getSalary() {

        return salary;
    }

    public String getName(){
        return name;
    }

}
