package gsu.project.database;

import java.sql.*;

public class LoginDB {
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String databaseURL = "jdbc:mysql://--/airlinereservation";
	static final String databaseUsername = "dba";
	static final String databasePassword = "messi10$";
	
	// Self note: Match to gui but works good
	public String loginConn (String username) {
		
		String result = "";
		
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM customer WHERE username=" + "'" + username + "'");

			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				
				result = res.getString("password");
				//System.out.println("Password: " + result);
			}
			
			con.close();
			
		} catch (SQLException | ClassNotFoundException ex) {
			
			System.out.println("Something went wrong with the database");
			ex.printStackTrace();
			
		}
		
		return result;
	}
	
	// Self note: Could be changed to return something else but works good 
	public Boolean searchFor (String email) {
		
		Boolean result = false; 
		int check = 0;
		
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = 
					con.prepareStatement("SELECT * FROM customer WHERE email=" + "'" + email + "'");
		
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				check = res.getInt("ssn");
				System.out.println("ssn: " + check);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (check > 0) {
			
			result = true;
		}
		
		else {
			result = false;
		}
		
		return result;
	}
	
	// Use for forgot password button
	// Tested successfully
	public String returnPassword (String username, String security_A) {
		
		String result = "";
		String correctAns = "";
		String pword = "";
		String userAns = security_A;
		
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM customer WHERE username=" + "'" + username + "'");
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				pword = res.getString("password");
				correctAns = res.getString("security_a");
				
				System.out.println("Password: " + pword + "\nCorrect answer: " + correctAns);
			} 
			
			if (!userAns.equals(correctAns)) {
				
				result = "Incorrect answer to security question";
				
			}
			
			else if (userAns.equals(correctAns)) {
				
				result = "Your password is: "  + pword;
				
			}
			
			else {
				
				result = "I'm sorry we don't have an account with that username";
				

			}
			
			System.out.println(result);
			
			con.close();
			
		} catch (Exception ex) {

			ex.printStackTrace();

		}
		
		return result;
	}

}
