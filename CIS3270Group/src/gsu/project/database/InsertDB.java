package gsu.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import gsu.project.bizlogic.Customer;
import gsu.project.bizlogic.Flight;
import gsu.project.bizlogic.Booking;
import gsu.project.gui.AlertBox;


public class InsertDB {
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String databaseURL = "jdbc:mysql://localhost:3306/AirlineReservation";
	static final String databaseUsername = "root";
	static final String databasePassword = "";
	
	public Boolean success; 
	public ArrayList <Object> returnList;
	
	// Query to insert a new flight into the database 
	public static void insertFlight (Flight flight) {
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			String sql = "INSERT INTO flights(flight_number,departure_city,destination_city,depart_time,"
					+ "arrive_time,flight_date,num_seats,return_day)" + " VALUES(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, flight.getFlightNum());
			ps.setString(2, flight.getDepartureCity());
			ps.setString(3, flight.getDestinationCity());
			ps.setString(4, flight.getDepartTime());
			ps.setString(5, flight.getArriveTime());
			ps.setString(6, flight.getFlightDate());
			ps.setInt(7, flight.getNumOfSeats());
			ps.setString(8, flight.getReturnFlight());
			
			ps.executeUpdate();
			
			con.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
