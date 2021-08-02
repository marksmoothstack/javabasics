package com.ss.uto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadRoutes {

	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/utopia";
	public static final String user = "root";
	public static final String password = "root";

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		// Register Driver.
//		Class.forName(driver);
//		
//		// Create a connection
//		Connection conn = DriverManager.getConnection(url, user, password);
//		
//		//Statement
//		Statement stmt = conn.createStatement();
//		PreparedStatement pstmt = conn.prepareStatement("select * from route "
//				+ "where origin_id= ? OR destination_id = ?");
//		
//		//Execute
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter Origin Id to search");
//		String originId = scan.nextLine();
//		pstmt.setString(1, originId);
//		pstmt.setString(2, originId);
//		
//		ResultSet rs = pstmt.executeQuery();
//		while(rs.next()) {
//			System.out.println("Route ID: "+rs.getInt("id"));
//			System.out.println("Origin ID:"+rs.getString("origin_id"));
//			System.out.println("Dest ID:"+rs.getString("destination_id"));
//		}
//
//	}

}
