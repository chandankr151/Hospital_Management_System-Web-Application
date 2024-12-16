package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection conn;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/hospitaldb";
			String usr="root";
			String pass="govt";
			
			if(conn==null) {
				conn = DriverManager.getConnection(url, usr,pass);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
