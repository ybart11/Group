package gsu.project.gui.usingSceneBuilder;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.event.*;
import java.io.IOException;
import gsu.project.bizlogic.*;
import gsu.project.database.*;

public class RegistrationController extends Application {
	
	@FXML
	
	Scene scene;
	Stage primaryStage;
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
	private static TextField city;
	private TextField securityAnswerInput;
	
	Button submit;
	Button back;
	
	public static void main(String[] args) {
		launch(args);
	}
	
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			
			Button back = new Button();
			
			
			
			firstNameInput = new TextField();
			firstNameInput.setPromptText("Enter First Name");
		
			
			lastNameInput = new TextField();
			lastNameInput.setPromptText("Enter Last Name");
			
			addressInput = new TextField();
			addressInput.setPromptText("Enter address");
			
			zipcodeInput = new TextField();
			
			
			stateInput = new TextField();
			
			emailInput = new TextField();
			
			ssnInput = new TextField();
		
			
			usernameInput = new TextField();
			usernameInput.setPromptText("Enter username");
		
			
			passwordInput = new PasswordField();
			passwordInput.setPromptText("Enter Password");
			confirmPasswordInput = new PasswordField();
			

		
		
			
			back.setOnAction(e -> {
				Login login = new Login();
				try {
					login.start(primaryStage);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			});
			
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
				Scene scene = new Scene(root);
				Image iconBox = new Image("FlightPlane.png");
				primaryStage.getIcons().add(iconBox);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			
		}
		}
			public void backToLogin(ActionEvent e) throws IOException {
				Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
				primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
				scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
		}
		
}