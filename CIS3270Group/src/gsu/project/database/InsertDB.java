package gsu.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import gsu.project.bizlogic.Customer;
import gsu.project.bizlogic.Flight;
import gsu.project.bizlogic.Booking;
import gsu.project.gui.AlertBox;


public class InsertDB {
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String databaseURL = "jdbc:mysql://192.168.0.251:3306/airlinereservation";
	static final String databaseUsername = "dba";
	static final String databasePassword = "messi10$";
	
	public static Boolean success; 
	public ArrayList <Object> returnList;
	
	// Query to insert a new flight into the database 
	public static void insertFlight (Flight flight) {
		
		success = false; 
		
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
			
			success = true;

			
		} catch (Exception e) {
			
			System.out.println("something messed up in database! :-(");
			e.printStackTrace();
			success = false;
		}
		
	}
	
	// Query to insert new booking in the database 
	public static void insertBooking (Booking booking) {
		
		try {
			
			Class.forName(driver); 
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword); 
		 
			String sqlQ = "INSERT INTO bookedflights(ticket_number,flight_number,account_id,flight_date,"
					+ "flight_time,departCity,destinationCity,passenger_username,return_flight_Date)" 
			+ " VALUES(?,?,?,?,?,?,?,?,?)";
			
			String sql ="UPDATE flights SET num_seats = num_seats -1 WHERE flight_number=" + "'" + booking.getFlightNumber() + "'";

			PreparedStatement ps2 = con.prepareStatement(sql);
			
			ps2.executeUpdate();
			
			PreparedStatement ps = con.prepareStatement(sqlQ);
			
			ps.setInt(1, booking.getTicketNum());
			ps.setInt(2, booking.getFlightNumber());
			ps.setInt(3, booking.getCustomerID());
			ps.setString(4, booking.getFlightDate());
			ps.setString(5, booking.getFlightTime());
			ps.setString(6, booking.getDeptCity());
			ps.setString(7, booking.getDesCity());
			ps.setString(8, booking.getPassenger_userName());
			ps.setString(9, booking.getReturnFlight());
			
			ps.executeUpdate();
			
			con.close();
			
			AlertBox.display("Thank you for flying with us", "You reservation is for flight: " + booking.getFlightNumber()
			+ "\nTicket number is: " + booking.getTicketNum());
			
			
			
		} catch (SQLIntegrityConstraintViolationException e1) {
			AlertBox.display("Duplicate Booking Alert!", "You already have a reservation booked for this flight" +
					"\nCheck that you entered the correct flight number");
			e1.printStackTrace();

		} catch (SQLException e2) {
			System.out.println("Syntax Error in SQL");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void insertCustomer (Customer customer) {
		
		success = false; 
		try {
			
			Class.forName(driver); 
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword); 
			
			String sqlQuery = "INSERT INTO account(account_id,username,password,firstname,lastname,address,"
					+ "state,email,zipcode,ssn,security_q,security_a,is_Admin)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

			
			PreparedStatement ps = con.prepareStatement(sqlQuery);

			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getUserName());
			ps.setString(3, customer.getPassword());
			ps.setString(4, customer.getFirstName());
			ps.setString(5, customer.getLastName());
			ps.setString(6, customer.getAddress());
			ps.setString(7, customer.getState());
			ps.setString(8, customer.getEmail());
			ps.setInt(9, customer.getZip());
			ps.setInt(10, customer.getSsn());
			ps.setString(11, customer.getSecurityQuestion());
			ps.setString(12, customer.getSecurityAnswer());
			ps.setBoolean(13, Customer.isAdmin);

			ps.executeUpdate();
			
			con.close();
			
			success = true;
			
		} catch (SQLIntegrityConstraintViolationException ex) {
			AlertBox.display("Duplicate Account Alert!", "We have an account already with your email address" 
					+ "\nPlease try again or use our password recovery system");
			
			success = false;
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		} catch (ClassNotFoundException e2) {
			System.out.println("something messed up in database! :-(");
			e2.printStackTrace();
		}
	}
		
}



