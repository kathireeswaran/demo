package com.cg.ems.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.ems.model.Employee;

public class EmployeeDaoImpl implements EmployeeDAO{
	
	List<Employee> list = new ArrayList<>();

	@Override
	public int addEmployee(Employee employee) {
		
		list.add(employee);
		return 1;
	}

}

