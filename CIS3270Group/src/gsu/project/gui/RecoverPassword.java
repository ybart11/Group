package gsu.project.gui;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import gsu.project.database.*;

public class RecoverPassword extends Application {

	Scene scene;
	TextField emailInput;
	TextField confirmEmailInput;
	TextField securityInput;
	Button passwordRetrieve;
	Button back;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		emailInput = new TextField();
		confirmEmailInput = new TextField();
		confirmEmailInput.setPromptText("Email:");

	
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().add("What is your Mother's Maiden Name?");
		choiceBox.getItems().add("What is your middle name?");
		choiceBox.getItems().add("What is your first?");
		choiceBox.getItems().add("Who was your 5th Grade teacher?");
	
	
	passwordRetrieve.setOnAction(e -> {
		
		String email = emailInput.getText();
		String email2 = confirmEmailInput.getText(); 
		String answer = securityInput.getText();
		
		try { 
			
			checkEmail(email, email2);
			LoginDB check = new LoginDB();
			String display = check.returnPassword(email, answer);
			AlertBox.display("Attention", display);
			
		}
		
		catch (Exception ex) {
			AlertBox.display("Alert!", "The email address do not match: ");
		}
	});
	
	
	}
	
	public void checkEmail(String email, String email2) throws Exception {
		
		int i = email.compareTo(email2);
		
		if (i > 0 || i < 0) { 
				
			throw new Exception("Email address don't match");
		}
	}
	
}