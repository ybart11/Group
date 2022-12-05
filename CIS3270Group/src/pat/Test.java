package pat;

import gsu.project.gui.AlertBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Test extends Application{

		Stage window;
		Button button;
		Scene scene;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
	
			window = primaryStage;
			window.setTitle("Flight Reservations");
			
			button = new Button("Login");
			button.setOnAction(e -> AlertBox.display("Flight Reservations", "Alert Box"));
			
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			Scene scene = new Scene(layout, 300, 400);
			window.setScene(scene);
			window.show();
			
			
}
		
			
		}

