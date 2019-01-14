package com.cg.ems.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

	static List<Employee> list = new ArrayList<>();

	static {

		Employee employee1 = new Employee(1234, "pavan", "trainer", 54000);
		Employee employee2 = new Employee(1254, "satish", "TL", 64000);

		list.add(employee1);
		list.add(employee2);
	}

	@Override
	public Employee getEmployee(int id) throws EMSException {

		Employee employeeObject = null;

		for (Employee employee : list) {

			if (employee.getId() == id) {
				employeeObject = employee;
				break;
			}
		}

		if (employeeObject == null) {
			throw new EMSException("No employee present with the given id");
		}

		return employeeObject;
	}

	@Override
	public List<Employee> getAllEmployees() throws EMSException {

		return list;

	}
}
