package exercise;
import java.util.*;
/**
 * 这个练习实现了构造器重载，静态初始化块，无参数构造器等功能. 
 * @author Zeng Ge 
 *
 */
public class ConstructorTest {

	public static void main(String[] args) {

		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("harry",10000);
		staff[1] = new Employee("jack",20000);
		staff[2] = new Employee("rose",30000);
		
		for(Employee e :staff){
			System.out.println("name = " + e.getName() + ",id=" + e.getId() + ",salary =" + e.getSalary());
		}
	}

}

class Employee{
	private static int nextId;
	
	private int id;
	private String name = "";
	private double salary;
	
	static {
		Random generator = new Random();
		//set nextId to a random number between 0 and 9999
		nextId = generator.nextInt(1000);
	}
	
	//object initialization block
	{
		id = nextId ;
		nextId ++;
	}
	
	//three overloaded constructors
	
	public Employee(String n ,double s){
		name = n;
		salary = s;
	}
	
	public Employee(double s){
		//calls the Employee(String,double) constructor
		this("Employee #" + nextId,s);
	}
	//the defult constructor
	public Employee(){
		
	}

	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	public int getId(){
		return id;
	}
}