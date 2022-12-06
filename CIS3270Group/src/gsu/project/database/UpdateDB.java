package gsu.project.database;

import java.sql.*;
import gsu.project.bizlogic.Flight;

public class UpdateDB {
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String databaseURL = "jdbc:mysql://localhost:3306/AirlineReservation";
	static final String databaseUsername = "root";
	static final String databasePassword = "";
	
	public static Boolean result; 
	
	public static void deleteFlight(int flightNum) {
		
		result = false; 
		
		try {
			
			Class.forName(driver);

			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = 
					con.prepareStatement("DELETE FROM flights WHERE flight_number=" + "'" + flightNum + "'");

			// ps.setInt(1, flightNum);
			
			ps.executeUpdate();
		
			con.close();
			
			result = true;
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			result = false;
		
		}
		
	}
	
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
			
			result = true;
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			result = false;

		}
		
	}
	
	
	
	
}
