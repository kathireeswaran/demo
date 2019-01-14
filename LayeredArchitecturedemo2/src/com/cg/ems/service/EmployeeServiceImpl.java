package com.cg.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmployeeDAO;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	List<String> list = new ArrayList<>();

	EmployeeDAO employeeDao = new EmployeeDaoImpl();

	@Override
	public boolean validateFields(int id) throws EMSException {

		String idRegEx = "[0-9]{4}$";
		boolean listFlag = true;

		boolean result = Pattern.matches(idRegEx, String.valueOf(id));

		if (!result) {
			list.add("id should be exactly 4 digits \n");
		}

		if (!list.isEmpty()) {
			listFlag = false;
			throw new EMSException(list + "");
		}

		return listFlag;
	}

	@Override
	public Employee getEmployee(int id)throws EMSException {
		Employee employee =  employeeDao.getEmployee(id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees()throws EMSException {
		return employeeDao.getAllEmployees();
	}

}
