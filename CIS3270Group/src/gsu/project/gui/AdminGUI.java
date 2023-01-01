package gsu.project.gui;


import gsu.project.bizlogic.*;
import gsu.project.database.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminGUI extends Application {
	
	Scene scene;
	GridPane grid;
	Label whatNext;
	Button bookFlight;
	Button backButton;
	TableView<Flight> table;
	TextField ticketNumber;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		TableColumn<Flight, Integer> flightnum = new TableColumn<>("Flight #");
		flightnum.setMinWidth(50);
		flightnum.setCellValueFactory(new PropertyValueFactory<>("flightNum"));

		TableColumn<Flight, String> flightDate = new TableColumn<>("Flight Date");
		flightDate.setMaxWidth(100);
		flightDate.setCellValueFactory(new PropertyValueFactory<>("flightDate"));

		TableColumn<Flight, String> departcityColumn = new TableColumn<>("Departure");
		departcityColumn.setMinWidth(50);
		departcityColumn.setCellValueFactory(new PropertyValueFactory<>("departureCity"));

		TableColumn<Flight, String> destination = new TableColumn<>("Destination");
		destination.setMinWidth(50);
		destination.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));

		TableColumn<Flight, String> departtimeColumn = new TableColumn<>("Depart Time");
		departtimeColumn.setMinWidth(50);
		departtimeColumn.setCellValueFactory(new PropertyValueFactory<>("departTime"));

		TableColumn<Flight, String> arriveTimeColumn = new TableColumn<>("Arrive Time");
		arriveTimeColumn.setMaxWidth(100);
		arriveTimeColumn.setCellValueFactory(new PropertyValueFactory<>("arriveTime"));

		TableColumn<Flight, String> returnFlightColumn = new TableColumn<>("Return Date");
		returnFlightColumn.setMaxWidth(100);
		returnFlightColumn.setCellValueFactory(new PropertyValueFactory<>("returnFlight"));

		TableColumn<Flight, String> seatColumn = new TableColumn<>("Available Seats");
		seatColumn.setMinWidth(100);
		seatColumn.setMaxWidth(100);
		seatColumn.setCellValueFactory(new PropertyValueFactory<>("numOfSeats"));

		table = new TableView<>();
		table.setItems(RetrieveDB.getFlights());
		table.getColumns().addAll(flightnum, flightDate, returnFlightColumn, departcityColumn, destination, departtimeColumn,
				arriveTimeColumn, seatColumn);

		BorderPane borderpane = new BorderPane();

		TextField deleteFly = new TextField();
		deleteFly.setPromptText("Enter Flight # to Delete");
		
		

		backButton = new Button("<-Back ");

		Label booked = new Label("All Flights");
		BorderPane.setAlignment(booked, Pos.CENTER);

		Button logout = new Button("Log Out");

		Button addFlight = new Button("CREATE NEW FLIGHTS");
		
		Button deleteFlight = new Button("DELETE FLIGHT");
		
		Button myFlights = new Button("My Flights");

		ToolBar toolbar = new ToolBar(logout, backButton, addFlight,deleteFlight,deleteFly,myFlights);

		borderpane.setTop(toolbar);
		borderpane.setCenter(booked);
		borderpane.setBottom(table);
		borderpane.setPrefSize(700, 500);

		scene = new Scene(borderpane);
		primaryStage.setTitle("Admin Flight Edit Window");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		myFlights.setOnAction(e->{
			
			MainMenu admin = new MainMenu();
			
			try {
				admin.start(primaryStage);
				
			}catch(Exception e2) {
				
				e2.printStackTrace();
				
			}
			
			
			
		});
		
		
		deleteFlight.setOnAction(e->{
			
			
			int flightNum = Integer.parseInt(deleteFly.getText());
			try {
			UpdateDB.deleteFlight(flightNum);
			if(UpdateDB.result == false) {
				
				throw new Exception("Something Went Wrong");
				
			}else {
				AlertBox.display("Flight Deleted", "The Flight Has Been Deleted");
				
				
				AdminGUI adminScreen = new AdminGUI();
				try {
					adminScreen.start(primaryStage);
			
				}catch(Exception ex1) {
					ex1.printStackTrace();
				}
				
				
			}
			
			}catch(Exception ex) {
				AlertBox.display("Alert!!", ex.getMessage());
			}
			
		
			
		});
		

		addFlight.setOnAction(e -> {

			AddFlights addflight = new AddFlights();

			try {
				addflight.start(primaryStage);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		logout.setOnAction(e -> {

			Login loginScreen = new Login();

			try {
				gsu.project.gui.Login.currentCustomer = (new Customer());
				loginScreen.start(primaryStage);
				

			} catch (Exception e1) {

				e1.printStackTrace();
			}
		});

		

		backButton.setOnAction(e -> {
			Login login = new Login();
			try {
				login.start(primaryStage);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		});

	}
}