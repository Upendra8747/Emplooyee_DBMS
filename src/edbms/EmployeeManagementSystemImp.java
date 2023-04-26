package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.EmployeeNotFoundException;
import customException.InvalidChoiceException;
import customSorting.SortEmployeeByAge;
import customSorting.SortEmployeeById;
import customSorting.SortEmployeeByName;
import customSorting.SortEmployeeBySalary;
import edbms.Employee;

public class EmployeeManagementSystemImp implements EmployeeManagementSystem {
	Scanner scan = new Scanner(System.in);
	Map<String, Employee> db = new LinkedHashMap<String, Employee>();

	@Override
	public void addEmployee() {
		System.out.println("Enter Employee Age:");
		int age = scan.nextInt();
		System.out.println("Enter Employee Name:");
		String name = scan.next();
		System.out.println("Enter Employee salary:");
		double salary = scan.nextDouble();

		Employee emp = new Employee(age, name, salary);

		db.put(emp.getId(), emp);

		System.out.println("Employee Record Inserted Successfully");

		System.out.println("Employee Id is " + emp.getId());

	
		
	}

	@Override
	public void displayEmployee() {
		// Accept Employee Id -> qsp101 or qsp102 or qsp103
		System.out.println("Enter Employee Id:");
		String id = scan.next();// String name = scan.next().toUpperCase()
		id = id.toUpperCase();

		if (db.containsKey(id) == true) {// checking if id is present or not
			Employee emp = db.get(id);// getting the Employee object
			System.out.println("Id:" + emp.getId());
			System.out.println("Age:" + emp.getAge());
			System.out.println("Name:" + emp.getName());
			System.out.println("Salary:" + emp.getSalary());
			// System.out.println(emp); as toString() is Overridden
		} else {
			try {
				String message = "Employee with the Id" + id + "is not Found!";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	
		
	}

	@Override
	public void displayAllEmployee() {
		if (db.size() != 0) {
			System.out.println("Employee details are as follows");
			System.out.println("_______________________________");
			Set<String> keys = db.keySet();// qsp101 qsp102
			for (String key : keys) {
				Employee emp = db.get(key);
				System.out.println(emp);
				// System.out.println(db.get(key));
			}
		} else {
			try {
				throw new EmployeeNotFoundException("Employee DB is Empty nothing to display");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		
	}

	@Override
	public void removeEmployee() {
		System.out.println("Enter Employee id");
		String id = scan.next();
		id = id.toUpperCase();
		if (db.containsKey(id)) {
			System.out.println("Employee Record Found!!");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Employee Record Deleted Successfully!");
		} else {
			try {
				String message = "Employee with the Id " + id + " is not Found!";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		
	}

	@Override
	public void removeAllEmployee() {
		if (db.size() != 0) {
			System.out.println("Employee records availble " + db.size());
			db.clear();
			System.out.println("All Employee records deleted successfully");
			System.out.println("Employee records availble " + db.size());

		} else {

			try {
				String message = "Employee DB is Empty nothing to delete!!";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	
		
	}

	@Override
	public void updateEmployee() {
		// Accept Employee Id -> qsp101 or qsp101 or qsp101
		System.out.println("Enter Employee Id:");
		String id = scan.next();// String name = scan.next().toUpperCase()
		id = id.toUpperCase();
		if (db.containsKey(id)) {
			Employee std = db.get(id);

			System.out.println("1:Update Age\n2:Update Name\n3: Update Salary");
			System.out.println("Enter Choice:");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Present age is " + std.getAge());
				System.out.println("Enter Age to be Update:");
				int age = scan.nextInt();
				std.setAge(age);// std.setAge(scan.nextInt());
				System.out.println("Updated age is " + std.getAge());

				break;

			case 2:
				System.out.println("Enter Name:");
				String name = scan.next();
				std.setName(name);// std.setName(scan.next());
				break;

			case 3:
				System.out.println("Enter Salary:");
				int salary = scan.nextInt();
				std.setSalary(salary);// std.setSalary(scan.nextInt());
				break;

			default:
				try {
					String message = "Invalid choice, Kindly enter valid choice!";
					throw new InvalidChoiceException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		} else {

			try {
				String message = "Employee with the Id " + id + " is not Found!";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	
		
	}

	@Override
	public void countEmployee() {

		System.out.println("The number of Employee in DB are " + db.size());
	
		
	}

	@Override
	public void sortEmployee() {
		Set<String> keys = db.keySet();
		List<Employee> list = new ArrayList<Employee>();
		for (String key : keys) {
			list.add(db.get(key));
			// System.out.println(keys);
		}
		System.out.println("1:Sort By Id\n2:Sort By Age");
		System.out.println("3:Sort By Name\n4:Sort By Salary");
		System.out.println("Enter Choice");
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			Collections.sort(list, new SortEmployeeById());
			display(list);

			break;

		case 2:
			Collections.sort(list, new SortEmployeeByAge());
			display(list);

			break;

		case 3:
			Collections.sort(list, new SortEmployeeByName());
			display(list);

			break;

		case 4:
			Collections.sort(list, new SortEmployeeBySalary());
			display(list);
			break;

		default:
			try {
				String message = "Invalid Enter , Kindly enter valid choice";
				throw new InvalidChoiceException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	

		
	}
	private static void display(List<Employee> list) {
		for (Employee e : list) {
			System.out.println(e);
		}
	}
	@Override
	public void getEmployeeWithHigestSalary() {

		if (db.size() >= 2) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for (String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(list.size() - 1));// getting Employee object
		} else {

			try {
				String message = "No sufficient Students to compare";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	
		
	}

	@Override
	public void getEmployeeWithLowestSalary() {
		if (db.size() >= 2) {

			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for (String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(0));// getting Employee object
		} else {

			try {
				String message = "No sufficient Students to compare";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	
		
	}

}
