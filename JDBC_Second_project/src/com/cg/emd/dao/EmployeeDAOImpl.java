package com.cg.emd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.utility.JdbcUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	PreparedStatement statement = null;
	Connection connection = null;

	@Override
	public int insertEmployee(Employee employee) throws EMSException {

		int result = 0;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.insertQuery);
			statement.setString(1, employee.getName());
			statement.setDouble(2, employee.getSalary());
			statement.setString(3, employee.getAddress());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new EMSException("prepared statement not created");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new EMSException("statement not closed");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EMSException("connection not closed");
			}
		}
		return result;
	}

	@Override
	public int updateEmployee(Employee employee) throws EMSException {

		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.updateQuery);
			statement.setDouble(1, employee.getSalary());
			statement.setString(2, employee.getAddress());
			statement.setInt(3, employee.getId());
			result = statement.executeUpdate();

		} catch (SQLException e) {
			throw new EMSException("preapared statement nor created");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new EMSException("statement wasn't closed");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EMSException("connection wasn't closed");
			}
		}
		return result;
	}

	@Override
	public List<Employee> getAllEmployees() throws EMSException {

		List<Employee> list = new ArrayList<>();
		ResultSet resultSet = null;

		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.selectAllEmployeesQuery);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString(2);
				double salary = resultSet.getDouble("salary");
				String address = resultSet.getString("address");

				Employee employee = new Employee();
				employee.setId(id);
				employee.setAddress(address);
				employee.setName(name);
				employee.setSalary(salary);
				list.add(employee);
			}
		} catch (SQLException e) {
			throw new EMSException("statement not created");
		} finally {

			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new EMSException("resultset wasn't closed");
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new EMSException("statement wasn't closed");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EMSException("connection wasn't closed");
			}
		}
		return list;
	}

	@Override
	public List<Employee> getEmployeesOnSalary(double salary) throws EMSException {

		List<Employee> list = new ArrayList<>();
		ResultSet resultSet = null;

		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.selectEmployeesOnSalary);
			statement.setDouble(1, salary);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");

				Employee employee = new Employee();
				employee.setAddress(address);
				employee.setName(name);
				list.add(employee);
			}
		} catch (SQLException e) {
			throw new EMSException("statement not created");
		} finally {

			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new EMSException("resultset wasn't closed");
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new EMSException("statement wasn't closed");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EMSException("connection wasn't closed");
			}
		}
		return list;
	}
}
