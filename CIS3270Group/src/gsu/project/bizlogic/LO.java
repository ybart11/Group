package gsu.project.bizlogic;


import gsu.project.database.LoginDB;

// Class that logs in to database 
// Class that checks login 

public class LO {

	private String username;
	private String password;
	private Boolean confirmLogin;
	
	public LO() {
		
		
	}
	
	public LO(String newUsername, String newPassword) {
		
		this.username = newUsername;
		this.password = newPassword;
		this.confirmLogin = false;
		
		
	}
	
	public void checkPassword(String check) {
		
		// think "getPassword" links to LoginDBO
		if(this.getPassword().equals(check)) {
			setConfirmLogin(true);
			
		}
		
		else
			setConfirmLogin(false);
		
		
	}
	
	public Boolean executeLogin() {
		
		LoginDB log = new LoginDB(); 
		
		String check = log.loginConn(getUsername());
		
		checkPassword(check);
		
		return confirmLogin;
	}

	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getConfirmLogin() {
		return confirmLogin;
	}

	public void setConfirmLogin(Boolean confirmLogin) {
		this.confirmLogin = confirmLogin;
	}
}
