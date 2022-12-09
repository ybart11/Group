package gsu.project.database;

import gsu.project.bizlogic.Flight;

public class TestConnection {

	public static void main(String[] args) {
		
		// Retrieve a flight using flight_number
		RetrieveDB.retrieveFlight(123);
		
		// Retrieve a customer using username
		RetrieveDB.retrieveCustomer("yovanybartolome");
		
		
		// Add a flight using object
		Flight flight = new Flight ();
		flight.setFlightNum(654);
		flight.setArriveTime("8:15pm");
		flight.setDepartTime("6:00pm");
		flight.setDepartureCity("Edmond");
		flight.setArriveTime("New Jersey");
		flight.setFlightDate("10/03/22");
		InsertDB.insertFlight(flight);
		
		// Delete a flight using flight_number 126 
		UpdateDB.deleteFlight(126);
		
		
		
		
		
		

	}

}
