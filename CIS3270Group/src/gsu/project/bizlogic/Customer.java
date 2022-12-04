package gsu.project.bizlogic;

// Yovany 



public class Customer implements Comparable <Customer> {
	
	// Data fields 
	private int customerID;
	private String firstName;
	private String lastName;
	private String address;
	private int zip;
	private String state;
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
	
	
	public Customer(int customerID, String firstName, String lastName, String address, int zip, String state,
			String userName, String password, String email, int ssn, String securityQuestion, String securityAnswer) {
		this.customerID = customerID;
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

	// Get customer's ID
	public int getCustomerId() {
		return this.customerID;
	}
	
	// Set customer's ID 
	public void setCustomerId (int customerID) {
		this.customerID = customerID;
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
	

	
	
}
