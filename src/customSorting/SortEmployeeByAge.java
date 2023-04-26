package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		Integer x = e1.getAge();//21
		Integer y = e2.getAge();//22
		return x.compareTo(y);//return 21.compareTo(22);
		
		//return e1.getAge()-(e2.getAge();
	}


}
