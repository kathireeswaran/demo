package com.cg.ems.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	Connection connection = null;
	Statement statement = null;

	final String driver = "oracle.jdbc.driver.OracleDriver";
	final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	final String username = "system";
	final String password = "123";

	public void createTable() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		statement = connection.createStatement();
		statement.execute(QueryMapper.createQuery);
		System.out.println("table created..");
	}
	
	public int insertEmployee() throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		statement = connection.createStatement();
		
		int result = statement.executeUpdate(QueryMapper.insertQuery);
		
		return result;
	}
	
	public static void main(String[] args) {

		Main main = new Main();
		try {
			//main.createTable();
			int result = main.insertEmployee(); 
			System.out.println(result + " employees inserted..");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}



