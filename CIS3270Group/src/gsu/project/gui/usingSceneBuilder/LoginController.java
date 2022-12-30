package gsu.project.gui.usingSceneBuilder;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.IOException;
import gsu.project.bizlogic.*;
import gsu.project.database.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.fxml.FXMLLoader;

public class LoginController extends Application {
	
	Scene scene;
	Stage primaryStage;
	Button forgotPassword;
	Button login;
	Button signUp;
	TextField usernameInput;
	PasswordField passwordInput;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {		
		
		forgotPassword = new Button();
		login = new Button();
		signUp = new Button();
		
		
		
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
			Scene scene = new Scene(root);
			Image iconBox = new Image("FlightPlane.png");
			primaryStage.getIcons().add(iconBox);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
	}
}
	
		public void register(ActionEvent e) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
			primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
	}
}