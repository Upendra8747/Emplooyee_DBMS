package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		Double x = e1.getSalary();//5.5 -> Auto-Boxing
		Double y = e2.getSalary();//4.5
		return x.compareTo(y);//return (5.5).compareTo(4.5);
		
		//return e1.getName()-(e2.getAge());m
	}

}
