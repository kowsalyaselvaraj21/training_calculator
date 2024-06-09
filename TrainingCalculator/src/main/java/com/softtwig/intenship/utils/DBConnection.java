package com.softtwig.intenship.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection createConnection() {
		Connection con =null;
		try {
			//1.Loading driver/Configuration
			Class.forName("com.mysql.jdbc.Driver");
			//2.Get the connection - DBserver URL(jdbc:mysql://localhost:3306),Schema(smsdb),username(root),password(admin)
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/traineeCalc","root","admin");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}	

}
