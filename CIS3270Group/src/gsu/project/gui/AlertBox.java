package gsu.project.gui;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;

public class AlertBox {
	
	public static void display(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("Close the Window");
		closeButton.setOnAction(e -> window.close());
		
		
		
		
		
	}
}
