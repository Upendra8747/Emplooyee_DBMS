package edbms;

import java.util.Scanner;

import customException.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee DB!");
		System.out.println("_________________________");
		Scanner scan = new Scanner(System.in);
		EmployeeManagementSystem ems = new EmployeeManagementSystemImp();
		while (true) {
			System.out.println("1:Add Employee\n2:Display Employee");
			System.out.println("3:Display All Employee\n4:Remove Employee");
			System.out.println("5:Remove All Employee\n6:Update Employee");
			System.out.println("7:Count Employee\n8:Sort Employee");
			System.out.println("9:Get Employee WithHigest Salary \n10:Get Employee With LowestSalary");
			System.out.println("11:Exit\nEnter your Choice!!");

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				ems.addEmployee();
				break;

			case 2:
				ems.displayEmployee();
				break;

			case 3:
				ems.displayAllEmployee();
				break;

			case 4:
				ems.removeEmployee();
				break;

			case 5:
				ems.removeAllEmployee();
				break;

			case 6:
				ems.updateEmployee();
				break;

			case 7:
				ems.countEmployee();
				break;

			case 8:
				ems.sortEmployee();
				break;

			case 9:
				ems.getEmployeeWithHigestSalary();
				break;

			case 10:
				ems.getEmployeeWithLowestSalary();
				break;

			case 11:
				System.out.println("Thanku!!");
				System.exit(0);

			default:
				try {
					String message = "invalid choice, Kindly enter valid choice";

					throw new InvalidChoiceException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
