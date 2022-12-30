package gsu.project.gui;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;

import gsu.project.database.*;
import gsu.project.bizlogic.*;

public class MainMenu extends Application {
	
	Scene scene;
	GridPane grid;
	Label whatNext;
	Button backButton;
	Button bookFlight;
	TableView<Booking> table;
	TextField ticketNum;
	
	
	public static void main(String[] args) {
		launch(args);
	}

		@Override
		public void start(Stage primaryStage) throws Exception {
			
		
			TableColumn<Booking, Integer> ticketNum = new TableColumn<>("Ticket #");
			ticketNum.setMinWidth(50);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNum"));
			
			TableColumn<Booking, Integer> flightnum = new TableColumn<>("Flight #");
			flightnum.setMinWidth(70);
			flightnum.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

			TableColumn<Booking, String> departDate = new TableColumn<>("Depart Date");
			departDate.setMinWidth(100);
			departDate.setCellValueFactory(new PropertyValueFactory<>("flightDate"));

			TableColumn<Booking, String> dTime = new TableColumn<>("Depart Time");
			dTime.setMinWidth(100);
			dTime.setCellValueFactory(new PropertyValueFactory<>("flightTime"));
			
			TableColumn<Booking, String> dcity = new TableColumn<>("Depart City");
			dcity.setMinWidth(100);
			dcity.setCellValueFactory(new PropertyValueFactory<>("deptCity"));
			
			TableColumn<Booking, String> descity = new TableColumn<>("Destination City");
			descity.setMinWidth(100);
			descity.setCellValueFactory(new PropertyValueFactory<>("desCity"));

			TableColumn<Booking, String> rFlight = new TableColumn<>("Return Date");
			rFlight.setMinWidth(100);
			rFlight.setCellValueFactory(new PropertyValueFactory<>("returnFlight"));

			
			ObservableList<Booking> list = RetrieveDB.retrieveBookings(Login.currentCustomer.getCustomerId());
		
			table = new TableView<>();
			table.setItems(list);
			table.getColumns().addAll(ticketNum,flightnum, departDate, dTime,dcity,descity, rFlight);
			
			BorderPane borderpane = new BorderPane();
			
			Label whatNext = new Label("What would you like to do next?");
			BorderPane.setAlignment(whatNext,Pos.CENTER);
			
			Button bookFlight = new Button("Book A Flight");
			
			Button deleteFlight = new Button("Delete Flight");
			
			TextField deleteTicket = new TextField();
			deleteTicket.setPromptText("Ticket No. to Delete");
			
			backButton = new Button("<-Back ");
		
			Label booked = new Label("Current reservations:");
			BorderPane.setAlignment(booked, Pos.CENTER);
			
			Button logout = new Button("Log Out");
			
			ToolBar toolbar = new ToolBar(logout,backButton,bookFlight,whatNext,deleteTicket,deleteFlight);
			
		
			borderpane.setTop(toolbar);
			borderpane.setCenter(booked);
			borderpane.setBottom(table);		
			borderpane.setPrefSize(700,500);
			
		
			
			scene = new Scene(borderpane);
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
			
			backButton.setOnAction(e -> {
				
				if(Login.currentCustomer.getUserName().contains("Admin")) {
					
					AdminGUI admin = new AdminGUI();
					
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