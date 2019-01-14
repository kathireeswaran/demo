package com.cg.ems.main;

import java.util.List;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class SelectMain {

	public static void main(String[] args) {

		EmployeeService service = new EmployeeServiceImpl();
		List<Employee> list;
	
		try {
			list = service.getAllEmployees();
			if (list.size() > 0) {
				System.out.println("ID" + "         " + " NAME" + "         " + "SALARY" + "        " + "ADDRESS");
				for (Employee employee : list) {
					System.out.println(employee.getId() + "       " + employee.getName() + "      "
							+ employee.getSalary() + "        " + employee.getAddress());
				}
			} else {
				System.out.println("no employees returned");
			}
		} catch (EMSException e) {
			System.err.println(e.getMessage());
		}

	}
}
