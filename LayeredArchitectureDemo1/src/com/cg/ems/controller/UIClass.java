package com.cg.ems.controller;

import java.util.Scanner;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class UIClass {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("------ Employee management System ----- ");
		System.out.println("1.Add Empoloyee");
		System.out.println("2.update Employee");
		System.out.println("3.delete Employee");
		System.out.println("4.get Employee By Id");
		System.out.println("5.get All Employees");

		System.out.println("Select ur choice:");
		int choice = scanner.nextInt();

		EmployeeService service = new EmployeeServiceImpl();

		switch (choice) {

		case 1:

			scanner.nextLine();
			System.out.println("Enter Name");
			String name = scanner.nextLine();
			System.out.println("Enter Designation");
			String desig = scanner.nextLine();
			System.out.println("Salary");
			double salary = scanner.nextDouble();
			System.out.println("Enter Age");
			int age = scanner.nextInt();

			Employee employee = new Employee();
			employee.setAge(age);
			employee.setDesig(desig);
			employee.setName(name);
			employee.setSalary(salary);

			try {
				boolean result = service.validateFields(employee);

				if (result) {

					int id = service.addEmployee(employee);
					System.out.println("ur id is: " + id);
				}

			} catch (EMSException e) {
				System.err.println(e.getMessage());
			}

			break;

		case 2:

			break;

		case 3:

			break;

		case 4:

			break;

		case 5:

			break;

		default:
			break;
		}

	}

}
