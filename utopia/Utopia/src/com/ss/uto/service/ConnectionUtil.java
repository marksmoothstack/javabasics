package com.ss.uto.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public final String driver = "com.mysql.cj.jdbc.Driver";
	public final String url = "jdbc:mysql://localhost:3306/utopia";
	public final String user = "root";
	public final String password = "root";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection(ConnectionUtil.getProperty("jdbc:mysql://localhost:3306/utopia"),
//				ConnectionUtil.getProperty("root"), ConnectionUtil.getProperty("root"));
//		conn.setAutoCommit(Boolean.FALSE);
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}

	public static String getProperty(String propName) {
		try (InputStream is = new FileInputStream("resources/db.properties")) {
			Properties dbProp = new Properties();
			dbProp.load(is);
			return dbProp.getProperty(propName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
