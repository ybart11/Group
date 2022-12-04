package gsu.project.bizlogic;

import java.util.Random;

public class Booking {
	
	// Data fields
	private int ticketNum;
	private int accountID;
	private int flightNumber;
	private String flightDate;
	private String flightTime;
	private String deptCity;
	private String desCity;
	//private String passanger_userName;\\
	private String returnFlight;
	
	public Booking() {}

	public Booking(int ticketNum, int accountID, int flightNumber, String flightDate, String flightTime,
			String deptCity, String desCity, String returnFlight) {
		
		this.ticketNum = ticketNum;
		this.accountID = accountID;
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
	public static void bookFlight() {}

	public int getTicketNum() {
		return ticketNum;
	}
	
	// Method that generates random number for ticket number
	public static int makeTicketNum () {
		Random rand = new Random();
		int num = rand.nextInt(1000);
		return num;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
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

	public String getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(String returnFlight) {
		this.returnFlight = returnFlight;
	}
	
	
	
	
	
	
	
	
	

}
