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
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class Registration extends Application {
	
	Scene scene;
	VBox registerLayout;
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
	private static TextField emailInput;
	private static TextField ssnInput;
	private static TextField securityAnswerInput;
	
	private static Button submit;
	private static Button back;
	
	public static void main(String[] args) {
		launch(args);
	}
	
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			registerTitle = new Label("Welcome to PantherAir");
			registerTitle.setPadding((new Insets(0, 0, 10, 0)));
			
			firstName = new Label("First Name");
			
			
			
			lastName = new Label("Last Name");
			
			
			address = new Label("Address");
			
			
			zipcode = new Label("Zipcode");
			
			
			state = new Label("State");
			
			
			email = new Label("Email");
			
			
			ssn = new Label("SSN");
			
			
			username = new Label("Username");
			
			
			password = new Label("Password");
			
			
			confirmPassword = new Label("Re-type Password");
			
			
			securityQuestion = new Label("Security Question");
			
			
			securityAnswer = new Label("Security Answer");
			
			
			back = new Button("Back");
			submit = new Button("Submit");
			
			registerLayout = new VBox(20);
			scene = new Scene(registerLayout, 800, 750);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
			
			
			
			
		}

}
