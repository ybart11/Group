package gsu.project.gui.usingSceneBuilder;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import java.io.IOException;
import gsu.project.database.*;

public class RecoverPasswordController extends Application {
	
	Scene scene;
	Stage primaryStage;
	Image iconBox;
	Parent root;
	

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException {
	
	try {
		Parent root = FXMLLoader.load(getClass().getResource("RecoverPassword.fxml"));
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