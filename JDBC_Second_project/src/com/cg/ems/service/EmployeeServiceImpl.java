package com.cg.ems.service;

import java.util.List;

import com.cg.emd.dao.EmployeeDAO;
import com.cg.emd.dao.EmployeeDAOImpl;
import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDao = new EmployeeDAOImpl();

	@Override
	public int insertEmployee(Employee employee) throws EMSException {
		return employeeDao.insertEmployee(employee);
	}

	@Override
	public int updateEmployee(Employee employee) throws EMSException {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() throws EMSException {
		return employeeDao.getAllEmployees();
	}

	@Override
	public List<Employee> getEmployeesOnSalary(double salary) throws EMSException {
		return employeeDao.getEmployeesOnSalary(salary);
	}

}
