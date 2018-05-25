package Source;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class VoteDetailsController implements Initializable{
	/*
	 * Instance variables:
	 */
	
	/* The GUI components from the FXML file */
	
	@FXML
	private Button homeButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button backButton;
	
	@FXML
	private Button voteSetting$finishButton;
	@FXML
	private ChoiceBox<String> voteSetting$groupBox;
	@FXML
	private CheckBox voteSetting$openCheckBox;
	@FXML
	private CheckBox voteSetting$closeCheckBox;
	@FXML
	private DatePicker voteSetting$openDatePicker;
	@FXML
	private DatePicker voteSetting$closeDatePicker;
	@FXML
	private Hyperlink voteSetting$hyperlink;
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleVoteDetailsActions();
		voteSetting$groupBox.getItems().addAll("Public", "Private");
		voteSetting$hyperlink.setText("https://www.casual_voting.com/votes/id=17a8hd999ns15");
	}

	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleVoteDetailsActions(){
		homeButton.setOnAction(homeButtonHandler());
		logoutButton.setOnAction(logoutButtonHandler());
		backButton.setOnAction(backButtonHandler());
		voteSetting$finishButton.setOnAction(finishButtonHandler());
		
	}
	
	private EventHandler<ActionEvent> finishButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				if(voteSetting$openCheckBox.isSelected()){
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDate localDate = LocalDate.now();
					DataBase.currentVote.opentime =  localDate.toString();
				}else{
					if(DataBase.currentVote.opentime!=null){
						DataBase.currentVote.opentime =  voteSetting$openDatePicker.getValue().toString();
					}else{
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
						LocalDate localDate = LocalDate.now();
						DataBase.currentVote.opentime =  localDate.toString();
					}
					
				}
				if(voteSetting$closeCheckBox.isSelected()){
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDate localDate = LocalDate.now();
					DataBase.currentVote.closetime =  localDate.toString();
				}else{
					if(DataBase.currentVote.closetime!=null){
						DataBase.currentVote.closetime =  voteSetting$openDatePicker.getValue().toString();
					}else{
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
						LocalDate localDate = LocalDate.now();
						DataBase.currentVote.closetime =  localDate.toString();
					}
				}
				
				
				DataBase.currentVote.url = voteSetting$hyperlink.getText();
				if(voteSetting$groupBox.getValue()==null){
					DataBase.currentVote.privacy = true;
				}else{
					if(voteSetting$groupBox.getValue().equals("public")){
						DataBase.currentVote.privacy = true;
					} else {
						DataBase.currentVote.privacy = false;
					}
				}
				
				
				try {
					Parent p = FXMLLoader.load(getClass().getResource("accountHome.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					window.setScene(nextScene);
					window.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		return event;
	}
	
	
	private EventHandler<ActionEvent> backButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("createVote.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					window.setScene(nextScene);
					window.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		return event;
	}
	
	
	private EventHandler<ActionEvent> homeButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("accountHome.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					window.setScene(nextScene);
					window.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		return event;
	}
	
	/*
	 * Changes the scene to the login scene
	 */
	private EventHandler<ActionEvent> logoutButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("login.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					window.setScene(nextScene);
					window.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		return event;
	}
}