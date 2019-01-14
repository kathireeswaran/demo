package com.cg.ems.dao;

import java.util.List;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;

public interface EmployeeDAO {

	Employee getEmployee(int id) throws EMSException;

	List<Employee> getAllEmployees()throws EMSException;

}
