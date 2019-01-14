package com.cg.ems.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.utility.JdbcUtility;

public class CallableDemo {

	public static void main(String[] args) {

		CallableStatement statement = null;
		Connection connection = null;
		try {
			connection = JdbcUtility.getConnection();

			String query = "{call jee_abridged_proc(?,?,?)}";
			try {
				connection.setAutoCommit(false);
				statement = connection.prepareCall(query);
				statement.setString(1, "sriram");
				statement.setDouble(2, 56000);
				statement.setString(3, "Chennai");
				
				statement.registerOutParameter(1, Types.VARCHAR);
				
				
				int res = statement.executeUpdate();
				System.out.println(res + " inserted..");
				connection.commit();
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println(e.getMessage());
				}
			}
		} catch (EMSException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
