package gsu.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.0.251:3306/airlinereservation";
	private static final String usernameDB = "dba";
	private static final String passwordDB = "messi10$";
	

	public static Connection connect() throws SQLException {
		Connection con = null;
		
		try {
			
			Class.forName(DRIVER);
			
			con = DriverManager.getConnection(URL, usernameDB, passwordDB);
			System.out.println("Connection Success!");
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
		
			con.close();
		
		}
		
		return con;
		
	

	}

}
