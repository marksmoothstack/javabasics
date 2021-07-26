package com.ss.jb.six;

import java.sql.Connection;

public class SampleSingleton {
	
	// Singleton instance
	private static SampleSingleton single_instance = null;
	
	// Private variable
	private static Connection conn = null;

	// Method to get instance of class
	public static synchronized SampleSingleton getInstance() {
		if (single_instance == null)
			single_instance = new SampleSingleton();

		return single_instance;
	}

	// Getter method for conn
	public static Connection getConn() {
		return conn;
	}

	//Setter method for conn
	public static void setConn(Connection conn) {
		SampleSingleton.conn = conn;
	}
}
