package com.arident.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperations {

	
		private static String DB_URL = "jdbc:oracle:thin:@10.203.241.234:1521:SNM";
		private static String DB_USERNAME= "muse";
		private static String DB_PASSWORD = "muse";
		public static void main(String[] args) {
			
			Connection con;
			try {
				con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				PreparedStatement stmt = con.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?)");
				
				stmt.setInt(1, 123);
				stmt.setString(2, "Ashish");
				stmt.setString(3, "Poste");
				stmt.setString(4, "Bangalore");
				stmt.setBoolean(5, true);
				
				stmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
