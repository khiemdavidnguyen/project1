package com.java.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	//singleton design pattern
	
	private static Connection connection;
	private ConnectionUtil() {}
	
	public static Connection getConnection() throws IOException, SQLException {
		System.out.println("starting a method getConnection()");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		System.out.println("creating new Properties object");
		prop.load(new FileReader("C:\\Users\\kdngu\\eclipse-workspace\\Project1Final\\src\\connection.properties"));
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		System.out.println("About to create the connection");
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Fake Connection is created");
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is created");
		}
		System.out.println("Returning Connection Next");
		return connection;
	}
}
