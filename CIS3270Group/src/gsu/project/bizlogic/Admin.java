package gsu.project.bizlogic;

public class Admin extends Customer {

	public final static Boolean isAdmin = true;
	
	public Admin (String userName, String password) {
		super(userName, password);
	}

	public Admin(int customerID, String firstName, String lastName, String address, int zip, String state,
			String userName, String password, String email, int ssn, String securityQuestion, String securityAnswer) {
		super(firstName, lastName);

	}
	
	@Override
	public String toString() {
		return "\nUsername: " + getUserName() + "\npassword: " + getPassword()
		+ "\nAdmin status: " + isAdmin;
	}
	
	
}
