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
	GridPane grid;
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
	Label confirmPasswords;
	Label passwords;
	TextField firstNameInput;
	TextField lastNameInput;
	TextField addressInput;
	TextField zipcodeInput;
	TextField stateInput;
	TextField usernameInput;
	TextField emailInput;
	TextField ssnInput;
	TextField securityAnswerInput;
	PasswordField passwordInput;
	PasswordField confirmPasswordInput;
	
	Button submitButton;
	Button backButton;
	
	public static void main(String[] args) {
		launch(args);
	}
	
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			grid = new GridPane();
			primaryStage.setTitle("Registration");
			grid.setPadding(new Insets (10, 10, 10, 10));
			grid.setVgap(8);
			grid.setHgap(10);
			grid.setAlignment(Pos.CENTER);
			
			
			// Title
			registerTitle = new Label("Welcome to PantherAir");
			GridPane.setConstraints(registerTitle, 0, 0);
			
			// First name
			firstName = new Label("First Name:");
			GridPane.setConstraints(firstName, 0, 0);
			firstNameInput = new TextField();
			firstNameInput.setPromptText(" Enter First Name ");
			GridPane.setConstraints(firstNameInput, 0, 1);

			// Last Name
			lastName = new Label("Last Name:");
			GridPane.setConstraints(lastName, 0, 2);
			lastNameInput = new TextField();
			lastNameInput.setPromptText(" Enter Last Name ");
			GridPane.setConstraints(lastNameInput, 0, 3);

			// Address
			address = new Label(" Address: ");
			GridPane.setConstraints(address, 0, 4);
			addressInput = new TextField();
			addressInput.setPromptText(" Enter the Address ");
			GridPane.setConstraints(addressInput, 0, 5);

			// State
			state = new Label(" State: ");
			GridPane.setConstraints(state, 0, 6);
			stateInput = new TextField();
			stateInput.setPromptText(" Enter the State ");
			GridPane.setConstraints(stateInput, 0, 7);

			// Zip Code
			zipcode = new Label(" Zip Code: ");
			GridPane.setConstraints(zipcode, 0, 8);
			zipcodeInput = new TextField();
			zipcodeInput.setPromptText(" Enter Zip Code ");
			GridPane.setConstraints(zipcodeInput, 0, 9);

			// UserName
			username = new Label("Enter Username:");
			GridPane.setConstraints(username, 1, 0);
			usernameInput = new TextField();
			usernameInput.setPromptText(" Enter Username ");
			GridPane.setConstraints(usernameInput, 1, 1);

			// Passwords
			passwords = new Label(" Password: ");
			GridPane.setConstraints(passwords, 1, 2);
			passwordInput = new PasswordField();
			passwordInput.setPromptText("Enter you passwords ");
			GridPane.setConstraints(passwordInput, 1, 3);

			// Confirm Passwords
			confirmPasswords = new Label(" Confrim Passwords: ");
			GridPane.setConstraints(confirmPasswords, 1, 4);
			confirmPasswordInput = new PasswordField();
			confirmPasswordInput.setPromptText(" EnterConfirm Password ");
			GridPane.setConstraints(confirmPasswordInput, 1, 5);

			// Email
			email = new Label("Email: ");
			GridPane.setConstraints(email, 2, 0);
			emailInput = new TextField();
			emailInput.setPromptText("Enter Email Address: ");
			GridPane.setConstraints(emailInput, 2, 1);

			// SSN
			ssn = new Label(" Soical security number: ");
			GridPane.setConstraints(ssn, 1, 6);
			ssnInput = new TextField();
			ssnInput.setPromptText(" Enter SSN ");
			GridPane.setConstraints(ssnInput, 1, 7);

			// Security Question
			securityQuestion = new Label(" Security Question ");
			GridPane.setConstraints(securityQuestion, 1, 8);

			ChoiceBox<String> choicebox = new ChoiceBox<>();
			GridPane.setConstraints(choicebox, 1, 9);

			choicebox.getItems().add(" What is your favorite color?");
			choicebox.getItems().add(" What is your favorite number?");

					
			securityAnswer = new Label(" Security Answer ");
			GridPane.setConstraints(securityAnswer, 1, 10);
			securityAnswerInput = new TextField();
			securityAnswerInput.setPromptText(" Answer ");
			GridPane.setConstraints(securityAnswerInput, 1, 11);

			submitButton = new Button(" Submit Registration ");
			GridPane.setConstraints(submitButton, 0, 10);
			// Need to add Security Answer

			backButton = new Button(" <-Back ");
			GridPane.setConstraints(backButton, 0, 11);
			
			
			grid.getChildren().addAll(firstName, firstNameInput, lastName, lastNameInput, address, addressInput, zipcode,
					zipcodeInput, email, emailInput, state, stateInput, username, usernameInput, passwords, passwordInput,
					confirmPasswords, confirmPasswordInput, ssn, ssnInput, securityQuestion, securityAnswer, choicebox, securityAnswerInput,
					submitButton, backButton);
			
			scene = new Scene(grid, 700, 700);
			scene.getStylesheets().add(getClass().getResource("yer.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			submitButton.setOnAction(e -> {
				
				String readQuestion = choicebox.getValue();
				
				
				if(firstNameInput.getText().isEmpty()|| lastNameInput.getText().isEmpty() || addressInput.getText().isEmpty()
						|| emailInput.getText().isEmpty() || stateInput.getText().isEmpty() || zipcodeInput.getText().isEmpty()
						|| ssnInput.getText().isEmpty()|| usernameInput.getText().isEmpty() || passwordInput.getText().isEmpty()
						|| readQuestion.isEmpty() || securityAnswerInput.getText().isEmpty()) {
					
					
					AlertBox.display("Blank registration field", "Please fill in all info on registration form");
					
				}else {
						
				Customer.generateCustomer(firstNameInput.getText(), lastNameInput.getText(), addressInput.getText(),
						emailInput.getText(), stateInput.getText(), Integer.parseInt(zipcodeInput.getText()),
						Integer.parseInt(ssnInput.getText()), usernameInput.getText(), passwordInput.getText(),
						readQuestion, securityAnswerInput.getText());

				if (gsu.project.database.InsertDB.success) {

					AlertBox.display("Succesful Registration Message",
							"Thank you for registering with us" + "\nPlease login to book a flight");

					Login login = new Login();

					try {
						login.start(primaryStage);
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}

			});

			backButton.setOnAction(e -> {
				Login login = new Login();
				try {
					login.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			
			
		}

}
