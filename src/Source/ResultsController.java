package Source;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class ResultsController implements Initializable{
	/*
	 * Instance variables:
	 */
	@FXML
	private Button homeButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button backButton;
	@FXML
	private Label lblResult;
	@FXML
	private ListView<String> listview;
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleResultsActions();
		
		//Find the question in the database
		
		List<String> questionNames = new ArrayList<String>();
		for(Question q:DataBase.currentVote.questions){
			questionNames.add(q.questionTitle);
		}
		lblResult.setText("Vote results for vote: "+DataBase.currentVote.votename+ " . Currently "+ questionNames.size() +" people have participated in your vote.");
		
		listview.getItems().setAll(questionNames);
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleResultsActions(){
		homeButton.setOnAction(homeButtonHandler());
		logoutButton.setOnAction(logoutButtonHandler());
		backButton.setOnAction(backButtonHandler());
		listview.getSelectionModel().selectedItemProperty().addListener(listSelectionHandler());
	}
	
	//Deals with the listview
	private ChangeListener<String> listSelectionHandler(){
		ChangeListener<String> handler = new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldValue, String questionName) {
				//set the current question
				//change scene
				DataBase.currentQuestion = DataBase.getQuestion(questionName,DataBase.currentVote.votename);
				try {
					Parent p = FXMLLoader.load(getClass().getResource("popupQuestionResult.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = new Stage();
					window.setScene(nextScene);
					window.showAndWait();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		return handler;
	}
	
	/*
	 * Changes the scene to the home scene
	 */
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
	 * Handles the back button
	 */
	private EventHandler<ActionEvent> backButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("votePage.fxml"));
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