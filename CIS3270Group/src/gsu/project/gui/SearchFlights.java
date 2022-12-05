package gsu.project.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

import gsu.project.bizlogic.Admin;
import gsu.project.bizlogic.Flight;
import gsu.project.gui.Login;

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
		
		
	
	
	

 }
}