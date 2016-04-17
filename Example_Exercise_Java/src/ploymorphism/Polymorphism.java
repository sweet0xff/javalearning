package ploymorphism;

/**
 * 多态的实现.
 * Java核心技术第九版,第一卷,152页:" super并不是父类的引用,因为不能将super赋给另一个对象变量,它只是一个编译器调用超类方法的特殊关键字."
 * Created by Zeng on 2016/4/12.
 */
public class Polymorphism {
    public static void main(String[] args) {
        Manager boss = new Manager("jack",80000,1987,12,14); //实例化一个Manager对象.
        boss.setBouns(10000); //设置boss的分红.不能这样调用employee[0], employee是Employee类对象,而setBouns不是Employee类方法.

        Employee[] employees = new Employee[3]; //构造一个Employee对象数组.
        employees[0] = boss; //  数组第一个值指向一个子类对象boss
        employees[1] = new Employee("rose",5000,1999,11,11);
        employees[2] = new Employee("james",8000,1989,10,14);

        for(Employee e : employees){
            System.out.println("name" + e.getName() + " salary " + e.getSalary());
        }
    }
}



