package gsu.project.database;

import java.sql.*;
import gsu.project.bizlogic.Flight;

public class UpdateDB {
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String databaseURL = "jdbc:mysql://192.168.0.251:3306/airlinereservation";
	static final String databaseUsername = "dba";
	static final String databasePassword = "messi10$";
	
	public static Boolean result; 
	
	// Self note: tested successfully
	public static void deleteFlight(int flightNum) {
		
		result = false; 
		
		try {
			
			Class.forName(driver);

			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = 
					con.prepareStatement("DELETE FROM flights WHERE flight_number=" + "'" + flightNum + "'");

			// ps.setInt(1, flightNum);
			
			ps.executeUpdate();
			
			System.out.println("Flight deleted successfully!");
		
			con.close();
			
			result = true;
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			result = false;
		
		}
		
	}
	
	// Add if statement that checks if ticket number even exists
	public static void deleteBooking(int ticketNumber) {
		
		result = false;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);

			PreparedStatement ps = 
					con.prepareStatement("DELETE FROM bookedflights WHERE ticket_number=" + "'" + ticketNumber + "'");
			
			//ps.setInt(1, ticketNumber);

			ps.executeUpdate();
			
			con.close();
			
			System.out.println("Booked flight deleted successfully");
			
			result = true;
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			result = false;

		}
		
	}
	
	
	
	
}
