package com.cg.ems.main;

public interface QueryMapper {

	public static final String createQuery = "CREATE TABLE jee_abridged_master(id NUMBER PRIMARY KEY,name VARCHAR2(20),salary DECIMAL(8,3),address VARCHAR2(20))";
	
	public static final String insertQuery = "INSERT INTO jee_abridged_master VALUES(1111,'pavan kumar',54000,'Hyderabad')";

}
