package com.cg.ems.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.cg.ems.exceptions.EMSException;
import com.cg.ems.utility.JdbcUtility;

public class DBMDDemo {

	public static void main(String[] args) {

		try {
			Connection connection = JdbcUtility.getConnection();

			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println(metaData.getDriverMajorVersion());
			System.out.println(metaData.getDriverMinorVersion());
			System.out.println(metaData.getDriverName());
			System.out.println(metaData.getDriverVersion());
			System.out.println(metaData.getURL());
			System.out.println(metaData.getUserName());
			
		System.out.println(metaData.getNumericFunctions());
		System.out.println(metaData.getTimeDateFunctions());

		} catch (EMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
