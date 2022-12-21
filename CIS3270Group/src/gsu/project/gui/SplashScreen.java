package gsu.project.gui;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;



public class SplashScreen extends Application {
	
	AnchorPane anchorPane;
	
	@FXML
	private ImageView image;
	
	public static void main(String[] args) {
		launch(args);
	}
		@Override
		public void start(Stage primaryStage)  {
			
			
			AnchorPane anchorPane = new AnchorPane();
			ImageView image = new ImageView();
			
			
			FadeTransition fadeTransition = new FadeTransition(Duration.millis(5000), anchorPane);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0.0);
			fadeTransition.setCycleCount(1);
			
			fadeTransition.setOnFinished(e -> { 
				
				LoginController login = new LoginController();
				
				try {
					
					login.start(primaryStage);
					
				} catch(Exception e1) { 
					
					e1.printStackTrace();
					
				}
			});
			
			
			try {
				Parent root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
				Scene scene = new Scene(root);
				Image iconBox = new Image("FlightPlane.png");
				primaryStage.getIcons().add(iconBox);
				primaryStage.setScene(scene);
				primaryStage.show();
				fadeTransition.play();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			}
			
			
					
			
		}

