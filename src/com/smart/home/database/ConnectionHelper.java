package com.smart.home.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

	private ConnectionHelper() {
	}

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Unable to locate com.mysql.jdbc.Driver", e);
		}

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartHome", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException("Unable to connect to database.", e);
		}
	}
}
