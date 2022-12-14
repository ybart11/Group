package gsu.project.gui.usingSceneBuilder;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

import gsu.project.bizlogic.Admin;
import gsu.project.bizlogic.Flight;
import gsu.project.gui.usingSceneBuilder.Login;

public class SearchFlights extends Application {
	
	Scene scene;
	GridPane pane;
	Label departureCity;
	Label destinationCity;
	Label departureDate;
	Label arrivalDate;
	Label passenger;
	Button search;
	Button departureButton;
	Button destinationButton;
	Button book;
	LocalDate lD;
	LocalDate lD2;
	TextField passengerInput;
	Button back;
	
	public String departDay;
	public String returnDay;
	public String departFrom;
	public String arriveTo; //
	public static ObservableList<Flight> flights;
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	public void start(Stage primaryStage) throws Exception {
		

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		
		departureCity = new Label(" From ");
		GridPane.setConstraints(departureCity, 0, 0);
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		GridPane.setConstraints(choiceBox, 0, 1);
		
		choiceBox.getItems().add("Atlanta");
		choiceBox.getItems().add("Chicago");
		choiceBox.getItems().add("New York");
		choiceBox.getItems().add("Miami");
		choiceBox.getItems().add("Los Angeles");
		choiceBox.getItems().add("Edmond");
		
		destinationCity = new Label("To");
		GridPane.setConstraints(destinationCity, 1, 0);
		
		ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
		GridPane.setConstraints(choiceBox1, 1, 1);
		
		choiceBox1.getItems().add("Atlanta");
		choiceBox1.getItems().add("Chicago");
		choiceBox1.getItems().add("New York");
		choiceBox1.getItems().add("Miami");
		choiceBox1.getItems().add("Los Angeles");
		choiceBox1.getItems().add("Edmond");
	
		departureDate = new Label("Depart Date");
		GridPane.setConstraints(departureDate, 0, 3);
		
		
		DatePicker datePicker = new DatePicker();
		datePicker.setOnAction(e -> {
			lD = datePicker.getValue();
			
			
		});
		
		book = new Button("Book");
		
		

			
		try {
			Parent root = FXMLLoader.load(getClass().getResource("SearchFlights.fxml"));
			Scene scene = new Scene(root);
			Image iconBox = new Image("FlightPlane.png");
			primaryStage.getIcons().add(iconBox);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
 }
}