package gsu.project.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/AirlineReservation";
	private static final String usernameDB = "root";
	private static final String passwordDB = "";

	public static void main(String[] args) {
		try {
			
			Connection con = DriverManager.getConnection(URL, usernameDB, passwordDB);
			
					System.out.println("Connection Success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}