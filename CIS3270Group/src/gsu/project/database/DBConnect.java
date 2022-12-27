package gsu.project.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.0.251:3306/airlinereservation";
	private static final String usernameDB = "dba";
	private static final String passwordDB = "messi10$";

	public static void main(String[] args) {
		
		
		try {
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, usernameDB, passwordDB);
			System.out.println("Connection Success!");
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
