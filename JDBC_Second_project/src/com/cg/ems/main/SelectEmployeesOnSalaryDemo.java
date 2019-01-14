package com.cg.ems.main;

import java.util.List;
import java.util.Scanner;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class SelectEmployeesOnSalaryDemo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the salary to get the Employees");
		double salary = scanner.nextDouble();

		EmployeeService employeeService = new EmployeeServiceImpl();
		try {
			List<Employee> list = employeeService.getEmployeesOnSalary(salary);

			if (!list.isEmpty()) {

				System.out.println("NAME" + " ----- " + "ADDRESS");
				for (Employee employee : list) {
					System.out.println(employee.getName() + " ----- " + employee.getAddress());
				}
			} else {
				System.out.println("no employees returned");
			}
		} catch (EMSException e) {
			System.err.println(e.getMessage());
		}
	}
}
