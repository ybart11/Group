package gsu.project.bizlogic;

import java.util.Random;
import gsu.project.database.RetrieveDB;

public class Booking {
	
	// Data fields
	private int ticketNum;
	private int customerID;
	private int flightNumber;
	private String flightDate;
	private String flightTime;
	private String deptCity;
	private String desCity;
	private String passenger_userName;
	private String returnFlight;
	
	public Booking() {}

	public Booking(int ticketNum, int customerID, int flightNumber, String flightDate, String flightTime,
			String deptCity, String desCity, String returnFlight) {
		
		this.ticketNum = ticketNum;
		this.customerID = customerID;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.deptCity = deptCity;
		this.desCity = desCity;
		this.returnFlight = returnFlight;
	}

	public Booking(int ticketNum, int flightNumber, String flightDate, String flightTime, String deptCity,
			String desCity, String returnFlight) {
		
		this.ticketNum = ticketNum;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.deptCity = deptCity;
		this.desCity = desCity;
		this.returnFlight = returnFlight;
	}
	
	// Method that will insert info into database
	public static void bookFlight(int flightNumber) {
		
		int ticketNum = makeTicketNum();
		Flight toBook = RetrieveDB.retrieveFlight(flightNumber);
	}

	public int getTicketNum() {
		return ticketNum;
	}
	
	// Method that generates random number for ticket number
	public static int makeTicketNum () {
		Random rand = new Random();
		int num = rand.nextInt(999);
		return num;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getDeptCity() {
		return deptCity;
	}

	public void setDeptCity(String deptCity) {
		this.deptCity = deptCity;
	}

	public String getDesCity() {
		return desCity;
	}

	public void setDesCity(String desCity) {
		this.desCity = desCity;
	}
	
	public String getPassenger_userName() {
		return passenger_userName;
	}

	public void setPassenger_userName(String passenger_userName) {
		this.passenger_userName = passenger_userName;
	}

	public String getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(String returnFlight) {
		this.returnFlight = returnFlight;
	}
	
	
	
	
	
	
	
	
	

}
