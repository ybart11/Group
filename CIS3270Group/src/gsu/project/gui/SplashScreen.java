package gsu.project.gui;

import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import javafx.application.Application;
import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;



public class SplashScreen extends Application {
	
	HBox hbox;
	Button go;
	
	public static void main(String[] args) {
		launch(args);
	}
		@Override
		public void start(Stage primaryStage) throws FileNotFoundException {
			
			hbox = new HBox();
			
			hbox.setPadding(new Insets(5, 5, 5, 5));
			
			FadeTransition fadeTransition = new FadeTransition(Duration.millis(10000), hbox);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0.0);
			fadeTransition.setCycleCount(1);
			
			fadeTransition.setOnFinished(e -> { 
				
				Login login = new Login();
				
				try {
					
					login.start(primaryStage);
					
				} catch(Exception e1) { 
					
					e1.printStackTrace();
					
				}
			});
			
			Image image = new Image("gsu.project.gui/plane-icon.png");
			
			ImageView imageView = new ImageView(image);
			
			imageView.setX(100);
			imageView.setY(95);
			
			imageView.setFitHeight(445);
			imageView.setFitWidth(500);
			
				Text splashText = new Text(25, 25, "Welcome to PantherAir");
			
			splashText.setFill(Color.WHITE);
			splashText.setFont(Font.font(java.awt.Font.SERIF, 35));
			
			imageView.setPreserveRatio(true);
			
			hbox.getChildren().addAll(imageView, splashText);
			
			
			Scene scene = new Scene(hbox, 700, 550, Color.BLACK);
			
			
			primaryStage.setTitle("Loading Image");
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
			fadeTransition.play();
			
					
			
		}

}
