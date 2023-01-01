package gsu.project.gui;

//1

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import gsu.project.database.*;

public class RecoverPassword extends Application {

	GridPane grid;
	Scene scene;
	Label email;
	TextField emailInput;
	Label confirmEmail;
	TextField confirmEmailInput;
	Label securityQuestion;
	Label securityAnswer;
	TextField securityAnswerInput;
	Button passwordRetrieve;
	Button backButton;
	Label displayPassword;
	Label wrongPassword;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		email = new Label(" Enter your email ");
		GridPane.setConstraints(email, 0, 0);
		emailInput = new TextField();
		emailInput.setPromptText(" Email ");
		GridPane.setConstraints(emailInput, 0, 1);
		
		confirmEmail = new Label(" Confrim your email ");
		GridPane.setConstraints(confirmEmail, 0, 2);
		confirmEmailInput = new TextField();
		confirmEmailInput.setPromptText(" Email ");
		GridPane.setConstraints(confirmEmailInput, 0, 3);
		
		securityQuestion = new Label(" Choose Security Question");
		GridPane.setConstraints(securityQuestion, 0, 4);
		
		ChoiceBox<String> choicebox = new ChoiceBox<>();
		GridPane.setConstraints(choicebox, 0, 5);
		
		choicebox.getItems().add("What is your favorite color?");
	
		securityAnswer = new Label(" Enter your Answer ");
		GridPane.setConstraints(securityAnswer, 0, 6);
		securityAnswerInput = new TextField();
		securityAnswerInput.setPromptText(" Answer:");
		GridPane.setConstraints(securityAnswerInput, 0, 7);

	    passwordRetrieve = new Button(" Retrieve Password ");
		GridPane.setConstraints(passwordRetrieve, 0, 8);
		
		backButton = new Button(" <-Back ");
		GridPane.setConstraints(backButton, 0, 9);
		
		displayPassword = new Label();
		GridPane.setConstraints(displayPassword, 1, 0);

	    
		grid.getChildren().addAll(email, emailInput, confirmEmail, confirmEmailInput, securityQuestion,
				                  choicebox,securityAnswer, securityAnswerInput, passwordRetrieve, backButton);
		
		scene = new Scene(grid, 600,600);
		primaryStage.setTitle("Password Recover");
		scene.getStylesheets().add("graphicUserInterface/thing.css");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		passwordRetrieve.setOnAction( e -> {
			String emailOne = emailInput.getText();
			String emailTwo = confirmEmailInput.getText();
			String answer = securityAnswerInput.getText();
			
			try {
				checkEmailMatch (emailOne, emailTwo);
				
				LoginDB check = new LoginDB();
				
				// Change to be user name instead of email
				String display = check.returnPassword(emailOne, answer);
				
				AlertBox.display("Attention", display);
				
				
				
			} catch (Exception ex) {
				AlertBox.display("Alert", "The email address do not match!");
			}
			
		});
		
		backButton.setOnAction( e -> {
			
			Login login = new Login ();
			
			try {
				login.start(primaryStage);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		});
	
}
	
	public void checkEmailMatch (String email, String email2) throws Exception {
		
		int i = email.compareTo(email2);
		
		if (i > 0 || i < 0) {
			throw new Exception ("Email Address don't match");
		}
		
	}

}