package gsu.project.gui;

// #2

import javafx.application.Application;
import javafx.geometry.Insets;
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

	Stage window;
	GridPane grid;
	Scene scene;
	Button login;
	Button signUp;
	Button forgotPassword;
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
		
		window = primaryStage;
		window.setTitle("Log In");
		
		grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);

		
		
		username = new Label(" Username: ");
		GridPane.setConstraints(username, 0, 0);
		
		
		password = new Label(" Password: ");
		GridPane.setConstraints(password, 0, 1);
		
		usernameInput = new TextField();
		usernameInput.setPromptText(" Enter username ");
		GridPane.setConstraints(usernameInput, 1, 0);
		
		passwordInput = new PasswordField();
		passwordInput.setPromptText(" Enter password ");
		GridPane.setConstraints(passwordInput, 1, 1);
		
		login = new Button(" Login ");
		GridPane.setConstraints(login, 1, 2);
		
		signUp = new Button(" Sign Up ");
		GridPane.setConstraints(signUp, 1, 3);
	
		
		forgotPassword = new Button(" Forgot Password? ");
		GridPane.setConstraints(forgotPassword, 1, 4);
		
		grid.getChildren().addAll(username, password, usernameInput, passwordInput, login, signUp, forgotPassword);
		
		scene = new Scene(grid, 400, 300);
		scene.getStylesheets().add(getClass().getResource("yer.css").toExternalForm());
		window.setScene(scene);
		window.show();
		
		signUp.setOnAction(e -> {
			
			Registration register = new Registration();
			
			try {
					register.start(window);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		login.setOnAction(e -> { 
			
			user = usernameInput.getText();
			
			String pw = passwordInput.getText();
			
			LO login = new LO(user, pw);
			
			if (pw.isEmpty() || user.isEmpty()) {
				
				AlertBox.display("ERROR", "Please enter your USERNAME and PASSWORD");
			
			} else if (login.executeLogin() == true) {
				
				if(user.contains("Admin")) { // 
					
					//currentCustomer = RetrieveDB.retrieveCustomer(user);
					
					// possible error with link to Customer
//					currentCustomer = new Admin(currentCustomer.getCustomerId(),currentCustomer.getUserName()
//							,currentCustomer.getPassword(), currentCustomer.getFirstName(), currentCustomer.getLastName(),
//							currentCustomer.getAddress(),currentCustomer.getState() , currentCustomer.getEmail(),
//							currentCustomer.getZip(), currentCustomer.getSsn(),currentCustomer.getSecurityQuestion(),
//							currentCustomer.getSecurityAnswer());
					
					
					AdminGUI adminScreen = new AdminGUI();
					try {
						adminScreen.start(primaryStage); 
						
					} catch(Exception ex1) {
						
						ex1.printStackTrace();
					}
					
					
				} else {
					
					currentCustomer = RetrieveDB.retrieveCustomer(user);
					System.out.println("Sucessfully logged in");
					
					
				}
				
				  try {
					  
					  MainMenu nextScreen = new MainMenu();
					  nextScreen.start(primaryStage);
					  
				  } catch (Exception exc1) {
					  exc1.printStackTrace();
					  
				  }
			}
			
				else {
					AlertBox.display("ERROR", "Incorrect Password");
				}
			
		});
		
		// Need to look over
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