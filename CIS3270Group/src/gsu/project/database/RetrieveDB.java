package gsu.project.database;

import gsu.project.bizlogic.Customer;
import gsu.project.bizlogic.Booking;
import gsu.project.bizlogic.Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RetrieveDB {
	
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String databaseURL = "jdbc:mysql://localhost:3306/AirlineReservation";
	static final String databaseUsername = "root";
	static final String databasePassword = "";
	
	
	// Get a customer from the database 
	public static Customer retrieveCustomer (String un) {
		Customer customer = new Customer ();
		

		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);

			PreparedStatement preparedStatement = 
					con.prepareStatement("SELECT * FROM customer WHERE username=" + "'" + un + "'");

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {

				customer.setCustomerId(res.getInt("account_id"));
				customer.setUserName(res.getString("username"));
				customer.setPassword(res.getString("password"));
				customer.setFirstName(res.getString("firstname"));
				customer.setLastName(res.getString("lastname"));
				customer.setAddress(res.getString("address"));
				customer.setState(res.getString("state"));
				customer.setEmail(res.getString("email"));
				customer.setZip(res.getInt("zipcode"));
				customer.setSsn(res.getInt("ssn"));
				customer.setSecurityQuestion(res.getString("security_q"));
				customer.setSecurityAnswer(res.getString("security_a"));

			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return customer;
		
		
	}
	
	public static ObservableList<Flight> getFlights() {
		
		 ObservableList<Flight> flights = FXCollections.observableArrayList();
		 
		 try {
			 
			Class.forName(driver);

			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
				
			PreparedStatement ps = 
					con.prepareStatement("SELECT * FROM flights");

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Flight flight = new Flight();

				flight.setFlightNum(rs.getInt("flight_number"));
				flight.setDepartureCity(rs.getString("departure_city"));
				flight.setDestinationCity(rs.getString("destination_city"));
				flight.setDepartTime(rs.getString("depart_time"));
				flight.setArriveTime(rs.getString("arrive_time"));
				flight.setFlightDate(rs.getString("flight_date"));
				flight.setReturnFlight(rs.getString("return_day"));
				flight.setNumOfSeats(rs.getInt("num_seats"));
				
				flights.add(flight);
			}
			
			// Close connection
			con.close();
			
		 } catch (Exception e1) {
			 e1.printStackTrace();
		 }
		 
		 return flights;

	}
	
	public static ObservableList<Booking> retrieveBookings(int customer_id) {
		
		 ObservableList<Booking> bookings = FXCollections.observableArrayList();
		 
		 try {
			 
			 Class.forName(driver);

			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = 
					con.prepareStatement("SELECT * FROM bookedflights WHERE account_id=" + "'" + customer_id + "'");
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				Booking booked = new Booking (res.getInt("ticket_number"),
						(res.getInt("flight_number")),
						(res.getString("flight_date")),
						(res.getString("flight_time")),
						(res.getString("departCity")),
						(res.getString("destinationCity")),
						(res.getString("return_flight_date")));
				
				bookings.add(booked);
				
			}	
			
				con.close();
			
			} catch (Exception e1) {
				
				e1.printStackTrace();
				
			}
			
		 return bookings;

		 }
	
	public static Flight retrieveFlight(int flightnum) {
		
		Flight flight = new Flight ();
		
		try {

			 Class.forName(driver);

			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = 
					con.prepareStatement("SELECT * FROM flights WHERE flight_number=" + "'" + flightnum + "'");
			
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {

				flight.setFlightNum(rs.getInt("flight_number"));
				flight.setDepartureCity(rs.getString("departure_city"));
				flight.setDestinationCity(rs.getString("destination_city"));
				flight.setDepartTime(rs.getString("depart_time"));
				flight.setArriveTime(rs.getString("arrive_time"));
				flight.setFlightDate(rs.getString("flight_date"));
				flight.setReturnFlight(rs.getString("return_day"));
				flight.setNumOfSeats(rs.getInt("num_seats"));

			}
			
			

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return flight;
		
	}
		
	}
	
	

