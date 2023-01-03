package gsu.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import gsu.project.bizlogic.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchDB {
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String databaseURL = "jdbc:mysql://--/airlinereservation";
	static final String databaseUsername = "dba";
	static final String databasePassword = "messi10$";
	
	
	public static ObservableList<Flight> findFlights(String departFrom,String arriveTo,
			String departDay,String returnDay){
		
		ObservableList<Flight> flights = FXCollections.observableArrayList();

		
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);

			PreparedStatement ps = 
					con.prepareStatement("SELECT * FROM flights WHERE departure_city=" + "'" + departFrom + "'" + 
			"and destination_city=" + "'" + arriveTo + "'" + "and flight_date=" + "'" + departDay + "'" 
							+ "and return_day=" + "'" + returnDay + "'");

			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
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
				
				System.out.println(flights.toString());
				
				
			}
			
			con.close();
				
		
	} catch(Exception ex) {
		
		System.out.println("Something went wrong with the database!");
	
		
	}
		return flights;
		
}

}
