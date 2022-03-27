package com.stud.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public class DBUtils {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/students_db", "root", "root");
		
		//logger
		return connection;
	}
}
