package com.cg.emd.dao;

public interface QueryMapper {

	public static final String insertQuery = "insert into jee_abridged_master values(jee_abridged_sequence.nextval,?,?,?)";

	public static final String updateQuery = "update jee_abridged_master set salary=?,address=? where id=?";

	public static final String selectAllEmployeesQuery = "select * from jee_abridged_master";

	public static final String selectEmployeesOnSalary = "select name,address from jee_abridged_master where salary>?";

}