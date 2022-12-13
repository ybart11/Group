package gsu.project.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String usernameDB = "root";
	private static final String passwordDB = "Georgiastate9";

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
