package gsu.project.gui;

//1

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import gsu.project.database.*;

public class RecoverPassword extends Application {

	GridPane grid;
	Scene scene;
	Label email;
	TextField usernameInput;
	Label confirmEmail;
	TextField confirmUsernameInput;
	Label securityQuestion;
	Label securityAnswer;
	TextField securityAnswerInput;
	Button passwordRetrieve;
	Button backButton;
	Label displayPassword;
	Label wrongPassword;
	
	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			
			grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			
			email = new Label(" Enter your username ");
			GridPane.setConstraints(email, 0, 0);
			usernameInput = new TextField();
			usernameInput.setPromptText(" Username ");
			GridPane.setConstraints(usernameInput, 0, 1);
			
			confirmEmail = new Label(" Confrim your username ");
			GridPane.setConstraints(confirmEmail, 0, 2);
			confirmUsernameInput = new TextField();
			confirmUsernameInput.setPromptText(" Username ");
			GridPane.setConstraints(confirmUsernameInput, 0, 3);
			
			securityQuestion = new Label(" Choose Security Question");
			GridPane.setConstraints(securityQuestion, 0, 4);
			
			ChoiceBox<String> choicebox = new ChoiceBox<>();
			GridPane.setConstraints(choicebox, 0, 5);
			
			choicebox.getItems().add("What is your favorite color?");
			choicebox.getItems().add("What is your favorite number?");
			choicebox.getItems().add("What is your middle name?");


			
		
			securityAnswer = new Label(" Enter your Answer ");
			GridPane.setConstraints(securityAnswer, 0, 6);
			securityAnswerInput = new TextField();
			securityAnswerInput.setPromptText(" Answer:");
			GridPane.setConstraints(securityAnswerInput, 0, 7);

		    passwordRetrieve = new Button(" Retrieve Password ");
			GridPane.setConstraints(passwordRetrieve, 0, 8);
			
			backButton = new Button(" <-Back ");
			GridPane.setConstraints(backButton, 0, 9);
			
			displayPassword = new Label();
			GridPane.setConstraints(displayPassword, 1, 0);

		    
			grid.getChildren().addAll(email, usernameInput, confirmEmail, confirmUsernameInput, securityQuestion,
					                  choicebox,securityAnswer, securityAnswerInput, passwordRetrieve, backButton);
			
			scene = new Scene(grid, 600,600);
			primaryStage.setTitle("Password Recover");
			scene.getStylesheets().add("graphicUserInterface/thing.css");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			passwordRetrieve.setOnAction(e->{
				
				String usernameOne = usernameInput.getText();
				String usernameTwo = confirmUsernameInput.getText();
				String Ans = securityAnswerInput.getText();
				
				
				try {
					
					checkUsernameMatch(usernameOne, usernameTwo);
					
					LoginDB check = new LoginDB();
					
					
					// Change to be user name instead of email
					String display = check.returnPassword(usernameOne,Ans);
					
					
					AlertBox.display("Attention", display);
				
				
				} catch(Exception ex) {
					
					AlertBox.display("Alert!", "The username do not match");
				}
				
			});
			
			backButton.setOnAction(e->{ 
				
				Login login = new Login();
				
				try {
					
					login.start(primaryStage);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			});
			
		}
	
		public void checkUsernameMatch(String un1,String un2) throws Exception {
			
			  int i = un1.compareTo(un2);
			  
			  if(i > 0 || i < 0) {
				  throw new Exception("User name don't match");
			  }
			  
			}

}