package gsu.project.gui.usingSceneBuilder;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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
import java.util.ArrayList;

import gsu.project.database.*;
import gsu.project.bizlogic.*;

public class MainMenu extends Application {
	
	Scene scene;
	GridPane grid;
	Label next;
	Button backButton;
	Button bookFlight;
	TableView<Booking> table;
	TextField ticketNum;
	
	
	public static void main(String[] args) {
		launch(args);
	}

		@SuppressWarnings("unchecked")
		@Override
		public void start(Stage primaryStage) throws Exception {
			
		
			TableColumn<Booking, Integer> ticketNum = new TableColumn<>("Ticket #");
			ticketNum.setMinWidth(50);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, Integer> flightNumber = new TableColumn<>("Flight #");
			ticketNum.setMinWidth(70);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("flight_number"));
			
			TableColumn<Booking, String> departDate = new TableColumn<>("Depart Date");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, String> departTime = new TableColumn<>("Depart Time");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, String> deptCity = new TableColumn<>("Depart City");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, String> desCity = new TableColumn<>("Destination City");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, String> returnFlight = new TableColumn<>("Return Date");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
		    
			
			
			table = new TableView<>();
			table.getColumns().addAll(ticketNum, flightNumber, departDate, departTime, deptCity, returnFlight, desCity);
			
			
			
			BorderPane borderpane = new BorderPane();
			
			Label next = new Label("What's next?");
			BorderPane.setAlignment(next, Pos.CENTER);
			
			
			
			Button bookFlight = new Button("Book A Flight");
			Button deleteFlight = new Button("Delete This Flight");
			TextField deleteTicket = new TextField();
			deleteTicket.setPromptText("Delete Ticket");
			Button back = new Button("<- BACK");
			Label booked = new Label("Current Flights Booked");
			BorderPane.setAlignment(booked, Pos.CENTER);
			Button logout = new Button("Log out");
			
			ToolBar toolbar = new ToolBar(bookFlight, deleteFlight, deleteTicket, 
					back, booked, logout);
			
			borderpane.setTop(toolbar);
			borderpane.setCenter(booked);
			borderpane.setBottom(table);
			borderpane.setPrefSize(500, 500);
			
			Parent root = FXMLLoader.load(getClass().getResource("/SceneBuilder.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Main Menu");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			logout.setOnAction(e -> {
				
				Login loginScreen = new Login();
				
				try {
					
					loginScreen.start(primaryStage);
					
					
				} 
				
				catch(Exception e1) {
					
					e1.printStackTrace();
				}
			});
			
			
			bookFlight.setOnAction(e -> {
				
				SearchFlights searchFlight = new SearchFlights();
				
				try {
					
					searchFlight.start(primaryStage);
					
				}
				
				catch(Exception e1) {
					
					e1.printStackTrace();
					
				}
			});
			
			back.setOnAction(e -> {
				
				if(Login.currentCustomer.getUserName().contains("Admin")) {
					
					AdminController admin = new AdminController();
					
					try {
						
						admin.start(primaryStage);
						
					}
					
					catch(Exception e3) {
						
						e3.printStackTrace();
					}
					
				}
				
				else {
					
					Login login = new Login();
					
					try {
						
						login.start(primaryStage);
						
					}
					
					catch(Exception e1) {
						
						e1.printStackTrace();
						
					}
				}
				
			});
			
			deleteFlight.setOnAction(e -> { 
				
				int tickNum = Integer.parseInt(deleteTicket.getText()); 
				
				try { 
					
					UpdateDB.deleteBooking(tickNum);
					if(UpdateDB.result == false) {
						throw new Exception("Something messed up");
						
					} 
					else { 
						AlertBox.display("Flight Deleted", "You no longer have a booking for flight" + tickNum);
					
					try {
						
						MainMenu nextScreen = new MainMenu();
						nextScreen.start(primaryStage);
					
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					}
					
					
				} catch (Exception ex) {
					AlertBox.display("Error", ex.getMessage());
				}
				
			});
		
		}
		
		
}