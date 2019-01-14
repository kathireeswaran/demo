package com.cg.ems.main;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.utility.JdbcUtility;

public class CallableFunctionDemo {

	public static void main(String[] args) {

		Connection connection = null;
		CallableStatement statement = null;

		try {
			connection = JdbcUtility.getConnection();
			String funCall = "{?=call name_function(?)}";

			try {
				statement = connection.prepareCall(funCall);
				statement.setInt(2, 1115);
				statement.registerOutParameter(1, Types.VARCHAR);

				statement.execute();

				System.out.println(statement.getString(1));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (EMSException e) {
			System.err.println(e.getMessage());
		}

	}

}
