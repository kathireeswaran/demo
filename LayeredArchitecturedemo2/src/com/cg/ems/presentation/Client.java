package com.cg.ems.presentation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class Client {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		EmployeeService service = new EmployeeServiceImpl();

		System.out.println("****** Employee Management Application ****** ");
		System.out.println("1.Add Employee");
		System.out.println("2.Edit Employee");
		System.out.println("3.delete Employee");
		System.out.println("4.select Employee By Id");
		System.out.println("5.select All Employees");

		System.out.println("Select ur choice:");
		int choice = 0;

		try {
			choice = scanner.nextInt();

			switch (choice) {

			case 1:

				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				System.out.println("Enter Id to search:");
				int id = scanner.nextInt();

				boolean flag;
				try {
					flag = service.validateFields(id);
					if (flag) {
						try {
							Employee employee = service.getEmployee(id);
							System.out.println(employee.getId() + ":" + employee.getName() + ":"
									+ employee.getDesignation() + ":" + employee.getSalary());
						} catch (EMSException e) {
							System.err.println(e.getMessage());
						}

					}
				} catch (EMSException e1) {
					System.err.println(e1.getMessage());
				}

				break;
			case 5:

				try {
					List<Employee> employees = service.getAllEmployees();
					
					for(Employee employee : employees) {
						System.out.println(employee.getId() + ":" + employee.getName() + ":"
								+ employee.getDesignation() + ":" + employee.getSalary());
					}
					
				} catch (EMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				break;
			}

		} catch (InputMismatchException e) {
			System.err.println("enter only digits (1-5)");
		}

	}

}
