package gsu.project.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import gsu.project.bizlogic.*;
import gsu.project.database.*;



public class Login extends Application {

	GridPane grid;
	Scene scene;
	Button forgotPassword;
	Button login;
	Button signUp;
	TextField usernameInput;
	PasswordField passwordInput;
	Label username;
	Label password;
	Color color;
	
	public static Customer currentCustomer;
	public static Admin currentAdmin;
	public static String user;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		
		signUp = new Button("Sign Up");
		GridPane.setConstraints(signUp, 0, 2);
		
		
		username = new Label("Username: ");
		GridPane.setConstraints(username, 0, 0);
		
		
		password = new Label("Password:");
		GridPane.setConstraints(password, 0, 1);
		
		
		login = new Button("Login");
		GridPane.setConstraints(login, 1, 2);
		
		usernameInput = new TextField();
		usernameInput.setPromptText("Enter USERNAME");
		GridPane.setConstraints(usernameInput, 1, 0);
		
		
		passwordInput = new PasswordField();
		passwordInput.setPromptText("Enter PASSWORD");
		GridPane.setConstraints(passwordInput, 1, 1);
		
		forgotPassword = new Button("Forgot Password?");
		GridPane.setConstraints(forgotPassword, 5, 0);
		
		grid.getChildren().addAll(signUp, usernameInput, password, passwordInput, login,
				forgotPassword, username);
		
		scene = new Scene(grid, 500, 500, Color.BEIGE);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		signUp.setOnAction(e -> {
			
			Registration register = new Registration();
			
			try {
					register.start(primaryStage);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		login.setOnAction(e -> { 
			
			user = usernameInput.getText();
			String pInput = passwordInput.getText();
			LO login = new LO(user, pInput);
			
			if (pInput.isEmpty() || user.isEmpty()) {
				AlertBox.display("ERROR", "Please enter your USERNAME and PASSWORD");
			
			} else if (login.executeLogin() == true) {
				
				if(user.contains("Admin")) {
					
					currentCustomer = RetrieveDB.retrieveCustomer(user);
					
					// possible error with link to Customer
					currentCustomer = new Admin(currentCustomer.getCustomerId(),currentCustomer.getUserName()
							,currentCustomer.getPassword(), currentCustomer.getFirstName(), currentCustomer.getZip(),
							currentCustomer.getAddress(),currentCustomer.getState() , currentCustomer.getEmail(),
							currentCustomer.getLastName(), currentCustomer.getSsn(),currentCustomer.getSecurityQuestion(),
							currentCustomer.getSecurityAnswer());
					
					
					AdminGUI adminScreen = new AdminGUI();
					try {
						adminScreen.start(primaryStage); 
						
					} catch(Exception ex1) {
						
						ex1.printStackTrace();
					}
					
					
				} else {
					
					currentCustomer = RetrieveDB.retrieveCustomer(user);
					
					
				}
				
				  try {
					  
					  MainMenu nextScreen = new MainMenu();
					  nextScreen.start(primaryStage);
					  
				  } catch (Exception exc1) {
					  exc1.printStackTrace();
					  
				  }
			}
			
				else {
					AlertBox.display("ERROR", "Incorrect PASSWORD");
				}
			
		});
		
		forgotPassword.setOnAction(e -> { 
			
			RecoverPassword passRecovery = new RecoverPassword();
			
			try {
				
				passRecovery.start(primaryStage);
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
 
}
}