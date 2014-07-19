package com.sample.rest.api.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/EMP";
	static final String USER = "username";
	static final String PASS = "password";
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static Connection getDbConnection(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		return DriverManager.getConnection(DB_URL,USER,PASS);
	}

}
