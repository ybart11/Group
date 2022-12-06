package gsu.project.gui;

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

	GridPane pane;
	Scene scene;
	Label email;
	TextField emailInput;
	Label confirmEmail;
	TextField confirmEmailInput;
	Label securityQuestion;
	Label securityAnswer;
	TextField securityInput;
	Button passwordRetrieve;
	Button back;
	Label displayPassword;
	Label wrongPassword;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	pane = new GridPane();
	pane.setAlignment(Pos.CENTER);
	
	email = new Label(" Enter your email ");
		GridPane.setConstraints(email, 0, 0);
		emailInput = new TextField();
		emailInput.setPromptText("Email");
		GridPane.setConstraints(emailInput, 0, 1);
	
	confirmEmail = new Label("Confirm your email");
		GridPane.setConstraints(email, 0, 0);
		
	confirmEmailInput = new TextField();
		confirmEmailInput .setPromptText("Email:");
		GridPane.setConstraints(confirmEmailInput, 0, 3);
		
	securityQuestion = new Label("Choose a security question");
	GridPane.setConstraints(securityQuestion, 0, 4);
	
	ChoiceBox<String> choiceBox = new ChoiceBox<>();
	GridPane.setConstraints(choiceBox, 0, 5);
	
	choiceBox.getItems().add("What is your Mother's Maiden Name?");
	choiceBox.getItems().add("What is your middle name?");
	choiceBox.getItems().add("What is your first?");
	choiceBox.getItems().add("Who was your 5th Grade teacher?");
	
	securityAnswer = new Label("Enter your answer");
	GridPane.setConstraints(securityAnswer, 0, 6);
	securityInput = new TextField();
	securityInput.setPromptText("Answer: ");
	GridPane.setConstraints(securityInput, 0, 7);
	
	passwordRetrieve = new Button("Retrieve Password");
	GridPane.setConstraints(passwordRetrieve, 0, 8);
	
	displayPassword = new Label();
	GridPane.setConstraints(displayPassword, 1, 0);
	
	pane.getChildren().addAll(email,emailInput, confirmEmail, confirmEmailInput, securityQuestion,
			choiceBox, securityAnswer, securityInput, passwordRetrieve, back);
	
	scene = new Scene(pane, 600, 600);
	primaryStage.setTitle("Recover Password");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	
	
}
}