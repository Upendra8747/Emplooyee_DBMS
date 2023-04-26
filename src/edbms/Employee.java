package edbms;

public class Employee {
	private String id;
	private int age;
	private String name;
	private double salary;
	
	static int count = 101;
	public Employee(int age,String name,double salary) {
		this.id="QSP"+count;
		this.age = age;
		this.name=name;
		this.salary= salary;
		count++;	
	}
	public String getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Employee.count = count;
	}
	public String toString() {
		return "Id: "+id+"Age: "+age+"Name: "+name+"Salary: "+salary;
	}
	
}
