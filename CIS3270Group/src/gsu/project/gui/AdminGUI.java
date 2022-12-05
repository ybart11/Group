package gsu.project.gui;


import gsu.project.bizlogic.*;
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
	Label next;
	Button bookFlight;
	Button back;
	TextField ticketNum;
	TableView<Flight> table;
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	public void start(Stage primaryStage) throws Exception {
	
		
		TableColumn<Flight, Integer> flightNum = new TableColumn<>("Flight #");
		flightNum.setMaxWidth(50);
		flightNum.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		
		TableColumn<Flight, String> flightDate = new TableColumn<>("Flight Date");
		flightDate.setMaxWidth(100);
		flightDate.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
		
		
		table = new TableView<>();
		table.getColumns().addAll(flightNum, flightDate);
		
		
		
		BorderPane borderPane = new BorderPane();
		
		
		TextField deleteFly = new TextField();
		deleteFly.setPromptText("Enter Flight # to Delete");
		
		
		back = new Button("<- Back ");
		
		
		Label booked = new Label("All Flights: ");
		BorderPane.setAlignment(booked, Pos.CENTER);
		
		Button logout = new Button("Log Out");
		Button addFlight = new Button("Add this Flight");
		Button deleteFlight = new Button("Delete Flight");
		Button myFlights = new Button("My Flights");
		
		ToolBar toolBar = new ToolBar(logout, back, addFlight, myFlights, deleteFlight, deleteFly);
		
		borderPane.setTop(toolBar);
		borderPane.setCenter(booked);
		borderPane.setBottom(table);
		borderPane.setPrefSize(700, 500);
		
		scene = new Scene(borderPane);
		primaryStage.setTitle("Admin Flight Edit Window");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		

		

 }
}