package com.cg.ems.main;

import java.util.Scanner;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = scanner.nextLine();
		System.out.println("Enter Salary");
		double salary = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Address");
		String address = scanner.nextLine();

		Employee employee = new Employee();
		employee.setName(name);
		employee.setAddress(address);
		employee.setSalary(salary);

		EmployeeService service = new EmployeeServiceImpl();
		
		try {
			int result = service.insertEmployee(employee);
			System.out.println(result + " employees inserted..");
		} catch (EMSException e) {
			System.err.println(e.getMessage());
		}
	}
}
