package gsu.project.gui;

// Where the Admin add flights 

import java.time.LocalDate;

import gsu.project.bizlogic.Flight;
import gsu.project.bizlogic.Flight.*;
import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;


public class AddFlights extends Application {
	
	GridPane grid;
	Scene scene;
	Label departureCity;
	Label destinationCity;
	Label departureDate;
	Label returnDate;
	Label leaveTime;
	Label arrivalTime;
	Label numberOfSeats;
	Button addButton;
	Button departureButton;
	Button destinationButton;
	LocalDate lD;
	LocalDate lD2;
	TextField passengerInput;
	Button backButton;
	TextField departureTime;
	TextField returnTime;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		grid = new GridPane();
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		
		departureCity = new Label("From ");
		GridPane.setConstraints(departureCity, 0, 0);
		
		// ChoiceBox for Depart cities
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.setValue("Select");
		GridPane.setConstraints(choiceBox, 0, 1);
		
		
		choiceBox.getItems().addAll("Atlanta, GA", "New York City, NY", "Los Angeles, CA", "Chicago, IL", "Houston, TX",
				"Phoenix, AZ", "Philadelphia, PA", "San Antonio, TX", "San Diego, CA", "Dallas, TX", "San Jose, CA",
				"Austin, TX", "Jacksonville, FL", "San Francisco, CA", "Charlotte, NC");
		
		destinationCity = new Label(" To ");
		GridPane.setConstraints(destinationCity, 1, 0);
		
		
		// ChoiceBox for Destination Cities
		ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
		choiceBox1.setValue("Select");
		GridPane.setConstraints(choiceBox1, 1, 1);
		
		choiceBox1.getItems().addAll("Atlanta, GA", "New York City, NY", "Los Angeles, CA", "Chicago, IL", "Houston, TX",
				"Phoenix, AZ", "Philadelphia, PA", "San Antonio, TX", "San Diego, CA", "Dallas, TX", "San Jose, CA",
				"Austin, TX", "Jacksonville, FL", "San Francisco, CA", "Charlotte, NC");
		
		departureDate = new Label(" Depart Date ");
		GridPane.setConstraints(departureDate, 0, 3);

		DatePicker dp = new DatePicker();
		dp.setOnAction(e -> {
			lD = dp.getValue();

		});

		StackPane root = new StackPane();
		root.getChildren().add(dp);
		GridPane.setConstraints(dp, 0, 4);

		returnDate = new Label(" Return Date ");
		GridPane.setConstraints(returnDate, 1, 3);

		DatePicker dp1 = new DatePicker();
		dp1.setOnAction(e -> {
			lD2 = dp1.getValue();

		});

		StackPane root1 = new StackPane();
		root1.getChildren().add(dp1);
		GridPane.setConstraints(dp1, 1, 4);
        
		leaveTime = new Label(" Depature Time ");
		GridPane.setConstraints(leaveTime, 2, 0);
		
		departureTime = new TextField();
		departureTime.setPromptText(" Depature Time "); // this will display gray line in the box
		GridPane.setConstraints(departureTime, 2, 1);
		
		arrivalTime = new Label(" Arrive Time ");
		GridPane.setConstraints(arrivalTime, 2, 3);
		
		returnTime = new TextField();
		returnTime.setPromptText(" Arrive Time "); // this will display gray line in the box
		GridPane.setConstraints(returnTime, 2, 4);
		
		
		Button addButton = new Button(" Add ");
		GridPane.setConstraints(addButton, 0, 8);

		backButton = new Button(" <-Back ");
		GridPane.setConstraints(backButton, 0, 9);
		
		departureCity = new Label(" From ");
		GridPane.setConstraints(departureCity, 0, 0);

		numberOfSeats = new Label(" Number of Seat ");
		GridPane.setConstraints(numberOfSeats, 2, 5);
		
		// Num of seats choicebox
		ChoiceBox<String> choicebox2 = new ChoiceBox<>();
		choicebox2.setValue("0");
		GridPane.setConstraints(choicebox2, 2, 6);

	
		
		choicebox2.getItems().addAll("30", "35", "40", "45", "50", "55", "60");
			

		grid.getChildren().addAll(departureCity, choiceBox, destinationCity, choiceBox1, dp, departureDate, dp1,
				returnDate, addButton, backButton, departureTime, leaveTime, returnTime, arrivalTime, choicebox2, numberOfSeats);
		
		
		addButton.setOnAction(e->{
			
			String departFrom = choiceBox.getValue();
			String whereTo = choiceBox1.getValue();
			String departOn = lD.toString();
			String returnOn = lD2.toString();
			int seats = Integer.parseInt(choicebox2.getValue());
		
			
			// error here (needs to be connected by DB)

		gsu.project.bizlogic.Flight.generateFlight(departFrom,whereTo, 
				departureTime.getText(),returnTime.getText(),departOn,
					returnOn,seats);
			

			
		});
		
		
		
		
		backButton.setOnAction(e -> {
			AdminGUI adminscreen = new AdminGUI();
			try {
				adminscreen.start(primaryStage);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		scene = new Scene(grid, 600, 600);
		primaryStage.setTitle(" Admin ");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	


	
	


		
		
	}
