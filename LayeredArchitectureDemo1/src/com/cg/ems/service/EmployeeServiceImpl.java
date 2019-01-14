package com.cg.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmployeeDAO;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDao = new EmployeeDaoImpl();
	
	@Override
	public boolean validateFields(Employee employee) throws EMSException {

		boolean resultFlag = false;

		List<String> list = new ArrayList<>();

		if (!validateName(employee.getName())) {
			list.add("Name length should vbe in between 5 to 10 & First Character Capital");
		}

		if (!validateAge(employee.getAge())) {
			list.add("Age should be greater than 18");
		}

		if (!list.isEmpty()) {
			throw new EMSException(list + "");
		} else {
			resultFlag = true;
		}

		return resultFlag;
	}

	public boolean validateName(String name) {

		String nameRegEx = "[A-Z]{1}[a-zA-Z]{4,10}$";
		return Pattern.matches(nameRegEx, name);
	}

	public boolean validateAge(int age) {

		boolean ageFlag = false;

		if (age >= 18) {
			ageFlag = true;
		}
		return ageFlag;

	}

	@Override
	public int addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

}
