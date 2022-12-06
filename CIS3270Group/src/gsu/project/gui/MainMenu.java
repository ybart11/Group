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
	Label next;
	Button backButton;
	Button bookFlight;
	TableView<Booking> table;
	TextField ticketNum;
	
	
	public static void main(String[] args) {
		launch(args);
	}

		@Override
		public void start(Stage primaryStage) throws Exception {
			
		
			TableColumn<Booking, Integer> ticketNum = new TableColumn("Ticket #");
			ticketNum.setMinWidth(50);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, Integer> flightNumber = new TableColumn("Flight #");
			ticketNum.setMinWidth(70);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("flight_number"));
			
			TableColumn<Booking, String> departDate = new TableColumn("Depart Date");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, String> departTime = new TableColumn("Depart Time");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, String> deptCity = new TableColumn("Depart City");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, String> desCity = new TableColumn("Destination City");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
			
			TableColumn<Booking, String> returnFlight = new TableColumn("Return Date");
			ticketNum.setMinWidth(100);
			ticketNum.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
		    
			
			
			table = new TableView<>();
			table.setItems(list);
			table.getColumns().addAll(ticketNum, flightNumber, departDate, departTime, deptCity );
		
		}
		
		
}
