package com.cg.ems.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.utility.JdbcUtility;

public class RSMDDemo {

	public static void main(String[] args) {

		try {
			Connection connection = JdbcUtility.getConnection();
			PreparedStatement statement = connection.prepareStatement("select *from jee_abridged_master");
			ResultSet resultSet = statement.executeQuery();

			ResultSetMetaData metaData = resultSet.getMetaData();

			System.out.println(metaData.getColumnCount());
			System.out.println(metaData.getColumnTypeName(2));
			System.out.println(metaData.getColumnName(3));

		} catch (EMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
