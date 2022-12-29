package gsu.project.bizlogic;

public class Admin extends Customer {

	public final static Boolean isAdmin = true;
	
	public Admin (String userName, String password) {
		super(userName, password);
	}

	public Admin(int customerID, String userName, String password ,String firstName, String lastName, String address, String state, 
		 String email, int zip, int ssn, String securityQuestion, String securityAnswer) {
		super(customerID, userName, password, firstName, lastName, address, state, email, zip, ssn, securityQuestion, securityAnswer);

	}
	
	@Override
	public String toString() {
		return "\nUsername: " + getUserName() + "\npassword: " + getPassword()
		+ "\nAdmin status: " + isAdmin;
	}
	
	
}
