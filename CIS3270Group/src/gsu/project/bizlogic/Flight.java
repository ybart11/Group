package gsu.project.bizlogic;

import java.util.ArrayList;
import java.util.Random;


public class Flight implements Comparable <Flight> {
	
	// Data fields 
	// private int id; <-- probably same as flightNum
	private int flightNum; 
	private String departureCity;
	private String destinationCity;
	private String departTime;
	private String arriveTime;
	private String flightDate;
	private String returnFlight;
	private ArrayList <Customer> passengers = new ArrayList<>();
	private int numOfSeats;
	
	public Flight () {}

	public Flight(int flightNum, String departureCity, String destinationCity, String departTime, String arriveTime,
			String flightDate, String returnFlight, ArrayList<Customer> passengers, int numOfSeats) {
		
		this.flightNum = flightNum;
		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.flightDate = flightDate;
		this.returnFlight = returnFlight;
		this.passengers = passengers;
		this.numOfSeats = numOfSeats;
	}
	
	// generateFlight and add to database method to be created
	public static void generateFlight() {}
	
	// getPassangers method to be created if needed
	
	// Method that generates a random flight number
	public static int generateFlightNum() {
		Random rand = new Random();
		int num = rand.nextInt(1000);
		return num;
		
	}

	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(String returnFlight) {
		this.returnFlight = returnFlight;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	
	@Override
	public String toString () {
		return "\nFlight number: " + getFlightNum() + "\nDeparture time: " + getDepartTime()
		+ "\nDeparture City: " + getDepartureCity() + "\nDestination City: " + getDestinationCity();
	}

	@Override
	public int compareTo(Flight o) {
		if (getFlightNum() > o.getFlightNum()) {
			return 1;
		}
		
		else if (getFlightNum() < o.getFlightNum()) {
			return -1;
		}
		else 
			return 0;
	}
	

}