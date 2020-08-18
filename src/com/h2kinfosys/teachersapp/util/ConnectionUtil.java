package com.h2kinfosys.teachersapp.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionUtil {

	private static String JNDI_NAME = "jdbc/TestDB";
	private static String JNDI_COMPANY = "companyName";
	private static String companyName = null;
	
	/*
	 * public static Connection getConnection() throws Exception{ // Driver driver =
	 * new Driver(); // DriverManager.registerDriver(driver);
	 * Class.forName("com.mysql.cj.jdbc.Driver"); Properties props = new
	 * Properties(); props.put("user", userName); props.put("password", password);
	 * Connection conn = DriverManager.getConnection(url,props); return conn; }
	 */
	
	public static Connection getConnection() throws Exception{
		InitialContext initContext = new InitialContext();
		Context context = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) context.lookup(JNDI_NAME);
		Connection conn = ds.getConnection();
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





	/**
	 * @return the companyName
	 */
	public static String getCompanyName() {
		return companyName;
	}





	/**
	 * @param companyName the companyName to set
	 */
	public static void setCompanyName(String companyName) {
		ConnectionUtil.companyName = companyName;
	}
	
}
