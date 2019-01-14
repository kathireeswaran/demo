package com.cg.ems.service;

import java.util.List;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;

public interface EmployeeService {

	boolean validateFields(int id)throws EMSException;

	Employee getEmployee(int id) throws EMSException;

	List<Employee> getAllEmployees() throws EMSException;

}
