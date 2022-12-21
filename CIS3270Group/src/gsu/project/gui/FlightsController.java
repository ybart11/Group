package gsu.project.gui;

import gsu.project.bizlogic.*;
import gsu.project.database.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.io.IOException;
import java.util.*;
import javafx.scene.control.cell.*;
import javafx.scene.image.Image;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;

public class FlightsController extends Application {
	
	TableView<Flight> table;
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TableColumn<Flight, Integer> flightNumber = new TableColumn<>("Flight #");
		flightNumber.setMinWidth(50);
		flightNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		
		TableColumn<Flight, String> flightDate = new TableColumn<>("Flight Date");
		flightDate.setMaxWidth(100);
		flightDate.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
		
		TableColumn<Flight, String> departCity = new TableColumn<>("Departure");
		departCity.setMinWidth(100);
		flightDate.setCellValueFactory(new PropertyValueFactory<>("departCity"));
		
		TableColumn<Flight, String> desCity = new TableColumn<>("Destination");
		desCity.setMinWidth(50);
		desCity.setCellValueFactory(new PropertyValueFactory<>("desCity"));
		
		TableColumn<Flight, String> departTime = new TableColumn<>("Depart Time");
		departTime.setMinWidth(50); 
		departTime.setCellValueFactory(new PropertyValueFactory<>("departTime"));
		
		TableColumn<Flight, String> arrivalTime = new TableColumn<>("Arival Time");
		arrivalTime.setMaxWidth(100);
		arrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		
		TableColumn<Flight, String> returnDate = new TableColumn<>("Return Date");
		returnDate.setMaxWidth(100);
		
		TableColumn<Flight, String> seatsAvailable = new TableColumn<>("Available Seats");
		seatsAvailable.setMinWidth(100);
		seatsAvailable.setMaxWidth(100);
		seatsAvailable.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));
		
		
		
		
		table = new TableView<>();
		table.setItems(SearchFlights.flights);

		Label label1 = new Label("Enter Flight Number");
		
		BorderPane.setAlignment(label1, Pos.CENTER);
		
		TextField inputFlightNum = new TextField("Flight Number");
		inputFlightNum.setText("Enter Flight No.");
		inputFlightNum.setMaxWidth(100);
		
		Button bookFlight = new Button("Press to Book Flight");
		
		Button back = new Button(" <- Back ");
		
		BorderPane.setAlignment(bookFlight, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(back, Pos.CENTER_LEFT);
		BorderPane.setAlignment(inputFlightNum, Pos.CENTER);
		
	
		
		bookFlight.setOnAction(e -> { 
			
			int flightnumber = Integer.parseInt(inputFlightNum.getText());
			
			Booking.bookFlight(flightnumber);
			
		});
		
		back.setOnAction(e -> { 
			
			SearchFlights searchFlight = new SearchFlights();
			
			try {
				
				searchFlight.start(primaryStage);
				
			}
			
			catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		});
		
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

}
