package com.h2kinfosys.teachersapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static String url = "jdbc:mysql://localhost:3306/sakila";
	private static String userName = "root";
	private static String password = "password";
	
	
	public static Connection getConnection() throws Exception{
		// Driver driver = new Driver();
		// DriverManager.registerDriver(driver);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties props = new Properties();
		props.put("user", userName);
		props.put("password", password);
		Connection conn = DriverManager.getConnection(url,props);
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			System.out.println(conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
