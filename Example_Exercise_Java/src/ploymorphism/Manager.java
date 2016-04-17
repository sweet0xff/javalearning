package ploymorphism;

/**
 * super.getSalary()方法调用父类的构造方法.因为Salary是一个私有属性,无法直接getSalary()获得.
 * Created by Zeng on 2016/4/12.
 */
public class Manager extends Employee {

    private double bouns;

    public Manager(String name,double salary,int year,int month,int day){
        super(name,salary,year,month,day);  //子类构造方法调用父类的构造方法进行初始化操作.
        bouns= 0 ;
    }

    public double getSalary(){
        double basesalary = super.getSalary();//调用父类的getSalary()获得基本工资.基本工资是一个私有属性.
        return basesalary + bouns;   //将基本工资加上奖金返回.
    }

    public void setBouns(double b){  //设置奖金
        this.bouns = b;

    }
}
