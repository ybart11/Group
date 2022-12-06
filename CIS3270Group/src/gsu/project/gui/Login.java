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
		GridPane.setConstraints(username, 25, 0);
		
		
		password = new Label("Password:");
		GridPane.setConstraints(password, 20, 1);
		
		
		login = new Button("Login");
		GridPane.setConstraints(login, 1, 2);
		
		usernameInput = new TextField();
		usernameInput.setPromptText("Enter USERNAME");
		GridPane.setConstraints(usernameInput, 1, 25);
		
		
		passwordInput = new PasswordField();
		passwordInput.setPromptText("Enter PASSWORD");
		GridPane.setConstraints(passwordInput, 1, 20);
		
		forgotPassword = new Button("Forgot Password?");
		GridPane.setConstraints(forgotPassword, 0, 3);
		
		grid.getChildren().addAll(signUp, usernameInput, password, passwordInput, login,
				forgotPassword, username);
		
		scene = new Scene(grid, 500, 500, Color.BEIGE);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}