package gsu.project.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;

import gsu.project.bizlogic.*;
import gsu.project.database.*;

public class Registration extends Application {
	
	Scene scene;
	GridPane pane;
	Label registerTitle;
	
	Label firstName;
	Label lastName;
	Label address;
	Label zipcode;
	Label state;
	Label username;
	Label email;
	Label ssn;
	Label securityQuestion;
	Label securityAnswer;
	Label confirmPassword;
	Label password;
	private static TextField firstNameInput;
	private static TextField lastNameInput;
	private static TextField addressInput;
	private static TextField zipcodeInput;
	private static TextField stateInput;
	private static TextField usernameInput;
	private static PasswordField passwordInput;
	private static PasswordField confirmPasswordInput;
	private static TextField emailInput;
	private static TextField ssnInput;
	private static TextField securityAnswerInput;
	
	Button submit;
	Button back;
	
	public static void main(String[] args) {
		launch(args);
	}
	
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			
			registerTitle = new Label("Welcome to PantherAir");
			registerTitle.setPadding((new Insets(0, 0, 10, 0)));
			
			
			
			firstName = new Label("First Name");
			GridPane.setConstraints(firstName, 0, 0);
			
			firstNameInput = new TextField();
			firstNameInput.setPromptText("Enter First Name");
			GridPane.setConstraints(firstNameInput, 0, 1);
			
			
			lastName = new Label("Last Name");
			GridPane.setConstraints(lastName, 0, 2);
			
			lastNameInput = new TextField();
			lastNameInput.setPromptText("Enter Last Name");
			GridPane.setConstraints(lastNameInput, 0, 3);
			
			
			
			address = new Label("Address");
			GridPane.setConstraints(address, 0, 4);
			
			addressInput = new TextField();
			addressInput.setPromptText("Enter address");
			GridPane.setConstraints(addressInput, 0, 5);
			
			
			zipcode = new Label("Zipcode");
			GridPane.setConstraints(zipcode, 0, 8);
			
			zipcodeInput = new TextField();
			zipcodeInput.setPromptText("Enter your Zipcode");
			GridPane.setConstraints(zipcodeInput, 0, 9);
			
			
			state = new Label("State");
			GridPane.setConstraints(state, 0, 6);
			
			stateInput = new TextField();
			stateInput.setPromptText("Enter the State");
			GridPane.setConstraints(stateInput, 0, 7);
			
			
			email = new Label("Email");
			GridPane.setConstraints(email, 2, 0);
			
			emailInput = new TextField();
			emailInput.setPromptText("Enter Email Address");
			GridPane.setConstraints(emailInput, 2, 1);
			
			
			ssn = new Label("SSN");
			GridPane.setConstraints(ssn, 1, 6);
			
			ssnInput = new TextField();
			ssnInput.setPromptText("Enter SSN");
			GridPane.setConstraints(ssnInput, 1, 7);
			
			
			username = new Label("Username");
			GridPane.setConstraints(username, 1, 0);
			
			usernameInput = new TextField();
			usernameInput.setPromptText("Enter username");
			GridPane.setConstraints(usernameInput, 1, 1);
			
			
			password = new Label("Password");
			GridPane.setConstraints(password, 1, 2);
			
			passwordInput = new PasswordField();
			passwordInput.setPromptText("Enter Password");
			GridPane.setConstraints(passwordInput, 1, 3);
			
			
			confirmPassword = new Label("Re-type Password");
			GridPane.setConstraints(confirmPassword, 1, 4);
			
			confirmPasswordInput = new PasswordField();
			confirmPasswordInput.setPromptText("Re-Enter Password");
			GridPane.setConstraints(confirmPasswordInput, 1, 5); 
					
			back = new Button("Back");
			GridPane.setConstraints(back, 0, 11);
			
			Button submit = new Button("Submit");
			GridPane.setConstraints(submit, 0, 10);
			
			pane.getChildren().addAll(firstNameInput, firstName, lastNameInput, lastName, 
					submit, zipcode, zipcodeInput, address, addressInput, ssn, ssnInput, username, 
					usernameInput, email, emailInput, back, confirmPassword, confirmPasswordInput, 
					password, passwordInput);
			
			scene = new Scene(pane, 700, 700);
			primaryStage.setScene(scene);
			primaryStage.show(); 
		
			
			back.setOnAction(e -> {
				Login login = new Login();
				try {
					login.start(primaryStage);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			});
			
			
		}

}