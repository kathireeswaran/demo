package com.cg.ems.main;

import java.util.Scanner;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class UpdateMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id:");
		int id = scanner.nextInt();
		System.out.println("Enter salary");
		double salary = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Address to update");
		String address = scanner.nextLine();

		Employee employee = new Employee();
		employee.setId(id);
		employee.setSalary(salary);
		employee.setAddress(address);

		EmployeeService service = new EmployeeServiceImpl();
		int result;
		try {
			result = service.updateEmployee(employee);
			System.out.println(result + " updated..");
		} catch (EMSException e) {
			System.err.println(e.getMessage());
		}
	}
}
