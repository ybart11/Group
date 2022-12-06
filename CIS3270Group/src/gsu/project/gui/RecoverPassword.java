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

public class RecoverPassword extends Application {

	GridPane pane;
	Scene scene;
	Label email;
	TextField emailInput;
	Label confirmEmail;
	TextField confirmEmailInput;
	Label securityQuestion;
	Label seurityAnswer;
	TextField securityInput;
	Button passwordRetreat;
	Button back;
	Label displayPassword;
	Label wrongPassword;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
	pane = new GridPane();
	pane.setAlignment(Pos.CENTER);
	
	email = new Label(" Enter your email ");
	GridPane.setConstraints(email, 0, 0);
	emailInput = new TextField();
	emailInput.setPromptText("Email");
	GridPane.setConstraints(emailInput, 0, 1);
	
	confirmEmail = new Label("Confirm your email");
		
	}
	
}
