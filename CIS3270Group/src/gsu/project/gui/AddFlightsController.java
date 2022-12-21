package gsu.project.gui;


import java.time.LocalDate;
import gsu.project.bizlogic.Flight.*;
import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;


public class AddFlightsController extends Application {
	
	GridPane pane;
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
		
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		
		departureCity = new Label("From ");
		GridPane.setConstraints(departureCity, 0, 0);
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		GridPane.setConstraints(choiceBox, 0, 1);
		
		
		choiceBox.getItems().add("Atlanta");
		choiceBox.getItems().add("Chicago");
		choiceBox.getItems().add("New York");
		choiceBox.getItems().add("Los Angeles");
		choiceBox.getItems().add("Edmond");
		
		destinationCity = new Label(" To ");
		GridPane.setConstraints(destinationCity, 1, 0);
		
		
		
		ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
		GridPane.setConstraints(choiceBox1, 1, 1);
		
		choiceBox1.getItems().add("Atlanta");
		choiceBox1.getItems().add("Chicago");
		choiceBox1.getItems().add("New York");
		choiceBox1.getItems().add("Los Angeles");
		choiceBox1.getItems().add("Edmond");
		
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
		departureTime.setPromptText(" Depature Time ");
		GridPane.setConstraints(departureTime, 2, 1);
		
		arrivalTime = new Label(" Arrive Time ");
		GridPane.setConstraints(arrivalTime, 2, 2);
		
		returnTime = new TextField();
		returnTime.setPromptText(" Arrive Time ");
		GridPane.setConstraints(returnTime, 2, 3);
		
		
		Button addButton = new Button(" Add ");
		GridPane.setConstraints(addButton, 0, 8);

		backButton = new Button(" <-Back ");
		GridPane.setConstraints(backButton, 0, 9);
		
		departureCity = new Label(" From* ");
		GridPane.setConstraints(departureCity, 0, 0);

		numberOfSeats = new Label(" Number of Seat ");
		GridPane.setConstraints(numberOfSeats, 2, 4);
		
		ChoiceBox<String> choicebox2 = new ChoiceBox<>();
		GridPane.setConstraints(choicebox2, 2, 5);

	
		
		choicebox2.getItems().add("170");
		choicebox2.getItems().add("262");
		choicebox2.getItems().add("851");
		choicebox2.getItems().add("301");
		
		
		

		pane.getChildren().addAll(departureCity, choiceBox, destinationCity, choiceBox1, dp, departureDate, dp1,
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
			AdminController adminscreen = new AdminController();
			try {
				adminscreen.start(primaryStage);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		scene = new Scene(pane, 600, 600, Color.DARKBLUE);
		primaryStage.setTitle(" Admin ");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	


	
	


		
		
	}
