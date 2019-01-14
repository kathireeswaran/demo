package com.cg.ems.service;

import java.util.List;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;

public interface EmployeeService {

	int insertEmployee(Employee employee) throws EMSException;

	int updateEmployee(Employee employee) throws EMSException;

	List<Employee> getAllEmployees() throws EMSException;

	List<Employee> getEmployeesOnSalary(double salary) throws EMSException;

}
