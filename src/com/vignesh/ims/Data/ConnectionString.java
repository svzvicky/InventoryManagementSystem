package com.vignesh.ims.Data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionString {

	public static final String URL = "jdbc:sqlserver://VLAB-LAB1-112\\SQLEXPRESS;databaseName=inventory";
	public static final String USER = "Eclipse";
	public static final String PASS = "Welcome@321";

	/**
	 * Get a connection to database
	 * 
	 * @return Connection object
	 * 
	 */
	public static Connection getConnection() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			return conn;
		} catch (SQLException | ClassNotFoundException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}

}
