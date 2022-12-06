package gsu.project.bizlogic;

import java.util.Random;

import gsu.project.database.InsertDB;




public class Customer implements Comparable <Customer> {
	
	// Data fields 
	private int customerId;
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private int zip;
	private String userName;
	private String password;
	private String email;
	private int ssn;
	private String securityQuestion;
	private String securityAnswer;
	public static boolean isAdmin = false;
	
	// No arg constructor 
	public Customer() {
		
		
	}
	
	// Constructor that defines username and password 
	public Customer (String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	
	public Customer(int customerId, String userName, String password, String firstName, String lastName, String address, String state,
			 String email,  int zip, int ssn, String securityQuestion, String securityAnswer) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.zip = zip;
		this.state = state;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.ssn = ssn;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	// Create generateAccount method 
	public static void generateAccount(String fname, String lname, String address, String email, String state, int zip,
			int ssn, String un, String pword, String secQuestion, String sa) {

		int id = makeCustomerID();

		Customer acct = new Customer(id, un, pword, fname, lname, address, state, email, zip, ssn, secQuestion, sa);

		InsertDB input = new InsertDB();

		input.insertAccount(acct);
	}
	
	// generates a random account ID
	public static int makeCustomerID() {

		Random rand = new Random();

		int ID = rand.nextInt(99999);

		return ID;
	}

	
	

	// Get customer's ID
	public int getCustomerId() {
		return this.customerId;
	}
	
	// Set customer's ID 
	public void setCustomerId (int customerId) {
		this.customerId = customerId;
	}
	
	// Get customer first name 
	public String getFirstName() {
		return firstName;
	}
	
	// Set customer first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// Get customer last name
	public String getLastName() {
		return lastName;
	}
	
	// Set customer last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Get customer address
	public String getAddress() {
		return address;
	}
	
	//
	public void setAddress(String address) {
		this.address = address;
	}
	
	// Get customer's state
	public String getState() {
		return state;
	}
	
	// Set customer's state 
	public void setState(String state) {
		this.state = state;
	}
	
	// Get customer zip code
	public int getZip() {
		return zip;
	}
	
	// Set customers zip code 
	public void setZip(int zip) {
		this.zip = zip;
	}
	

	
	// Get customer's username 
	public String getUserName() {
		return userName;
	}
	 
	// Set customer's username
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	// Get customer's password
	public String getPassword() {
		return password;
	}
	
	// Set customer's password
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	// Get customer's email 
	public String getEmail() {
		return email;
	}
	
	// Set customer's email 
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Get security question 
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	
	// Set security question
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	// Get security question's answer
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	
	// Set security question's answer
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	//
	public int getSsn() {
		return ssn;
	}
	
	//
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	

	@Override
	public int compareTo(Customer o) {
		if (getSsn() > o.getSsn()) {
			return 1;
		}
		else if (getSsn() < o.getSsn()) {
			return -1;
		}
		else 
			return 0;
	
	}
	@Override
	public String toString () {
		return "\nCustomerID: " + getCustomerId() + "\nUsername: " + getUserName() 
		+ "\nFirst name: " + getFirstName() + "\nLast name: " + getLastName();
	}
	

	
	
}
