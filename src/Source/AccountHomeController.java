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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class AccountHomeController implements Initializable{
	/*
	 * Instance variables:
	 */
	
	/* The GUI components from the FXML file */
	@FXML
	private Button homeButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button home$accountDetailsButton;
	@FXML
	private Button home$createVoteButton;
	@FXML
	private Button home$viewVoteAndDetailsButton;
	@FXML
	private ListView<String> home$recommendedVotesListView;
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleAccountHomeActions();
	}
	
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleAccountHomeActions(){
		logoutButton.setOnAction(logoutButtonHandler());
		home$accountDetailsButton.setOnAction(accountDetailsButtonHandler());
		home$createVoteButton.setOnAction(createVoteButtonHandler());
		home$viewVoteAndDetailsButton.setOnAction(viewVotesButtonHandler());
		List<String> votenames = new ArrayList<String>();
		for(Vote v:DataBase.votes){
			votenames.add(v.votename);
		}
		home$recommendedVotesListView.getItems().setAll(votenames);
		home$recommendedVotesListView.getSelectionModel().selectedItemProperty().addListener(listSelectionHandler());
	}
	
	/*
	 * used when a user selects a list item
	 */
	private ChangeListener<String> listSelectionHandler(){
		ChangeListener<String> handler = new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldValue, String votename) {
				//set the current vote
				//change scene
				DataBase.currentVote = DataBase.getVote(votename);
				try {
					Parent p = FXMLLoader.load(getClass().getResource("votePage.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = (Stage)homeButton.getScene().getWindow();
					window.setScene(nextScene);
					window.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		return handler;
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
	
	/*
	 * Changes the scene the account details scene
	 */
	private EventHandler<ActionEvent> accountDetailsButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("accountDetails.fxml"));
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
	 * Changes the scene the create vote scene
	 */
	private EventHandler<ActionEvent> createVoteButtonHandler(){
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
	
	/*
	 * Changes the scene the create vote scene
	 */
	private EventHandler<ActionEvent> viewVotesButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("voteList.fxml"));
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