package gsu.project.database;

import java.sql.*;

public class LoginDB {
	
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String databaseURL = "jdbc:mysql://192.168.0.251:3306/airlinereservation";
	static final String databaseUsername = "dba";
	static final String databasePassword = "messi10$";
	
	public String loginConn (String username) {
		
		String result = "";
		
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM CUSTOMER WHERE username=" + "'" + username + "'");

			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				
				result = res.getString("password");
			}
			
			con.close();
			
		} catch (SQLException | ClassNotFoundException ex) {
			
			System.out.println("Something went wrong with the database :(");
			ex.printStackTrace();
			
		}
		
		return result;
	}
	
	public Boolean searchFor (String email) {
		
		Boolean result = false; 
		int check = 0;
		
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = 
					con.prepareStatement("SELECT * FROM CUSTOMER WHERE username=" + "'" + email + "'");
		
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				check = res.getInt("ssn");
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
	
	public String returnPassword (String email, String security_A) {
		
		String result = "";
		String correctAns = "";
		String pword = "";
		String userAns = security_A;
		
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM CUSTOMER WHERE email=" + "'" + email + "'");
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				pword = res.getString("password");
				correctAns = res.getString("security_a");
				
				System.out.println(pword + correctAns);
			} 
			
			else if (userAns.equals(correctAns)) {
				result = "Your password is: "  + pword;
			}
			
			else {
				result = "I'm sorry we dont have an account with that email address";

			}
			
			con.close();
		} catch (Exception ex) {

			ex.printStackTrace();

		}
		
		return result;
	}

}
