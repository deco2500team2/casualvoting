package Source;

import java.io.IOException;
import java.net.URL;
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
public class Controller implements Initializable{
	/*
	 * Instance variables:
	 */
	private Account account;
	private Vote vote;
	
	private Stage window;
	
	private Scene loginScene;
	private Scene accountHomeScene;
	private Scene createVoteScene;
	private Scene editVoteScene;
	private Scene participateScene;
	private Scene resultsScene;
	private Scene voteDetailsScene;
	private Scene voteListScene;
	private Scene voteScene;
	
	/* The GUI components from the FXML file */
	@FXML
	private Button login$loginbutton;
	@FXML
	private Button login$registerButton;
	@FXML
	private TextField login$usernameTextField;
	@FXML
	private TextField login$passwordTextField;
	@FXML
	private ComboBox login$titleDropdown;
	@FXML
	private TextField login$firstnameTextField;
	@FXML
	private TextField login$surnameTextField;
	@FXML
	private TextField login$dobTextField;
	@FXML
	private TextField login$emailTextField;
	@FXML
	private TextField login$otherUsernameTextField;
	@FXML
	private TextField login$otherPasswordTextField;
	@FXML
	private TextField login$repeatPasswordTextField;
	@FXML
	private Button homeButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button backButton;
	@FXML
	private Button home$accountDetailsButton;
	@FXML
	private Button home$createVoteButton;
	@FXML
	private Button home$viewVoteAndDetailsButton;
	@FXML
	private ListView home$recommendedVotesListView;
	@FXML
	private ComboBox accountDetails$titleDropdown;
	@FXML
	private Button accountDetails$saveButton;
	@FXML
	private Button editVote$saveButton;
	@FXML
	private Button editVote$addQuestionButton;
	@FXML
	private Button editVote$viewQuestionButton;
	@FXML
	private Button editVote$deleteQuestionButton;
	@FXML
	private TextField editVote$voteTitleTextField;
	@FXML
	private TextField editVote$descriptionTextField;
	@FXML
	private Button createVote$saveButton;
	@FXML
	private Button createVote$addQuestionButton;
	@FXML
	private Button createVote$viewQuestionButton;
	@FXML
	private Button createVote$deleteQuestionButton;
	@FXML
	private TextField createVote$voteTitleTextField;
	@FXML
	private TextField createVote$descriptionTextField;
	@FXML
	private Button voteSetting$finishButton;
	@FXML
	private ChoiceBox voteSetting$groupBox;
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
	@FXML
	private Button vote$editVoteButton;
	@FXML
	private Button vote$participateButton;
	@FXML
	private Button vote$viewResultsButton;
	@FXML
	private Button vote$saveAndFinishButton;
	@FXML
	private Button voteList$searchButton;
	@FXML
	private ListView voteList$voteList;
	
	
	
	/**
	 * A constructor to initialise the controller with no parameters.
	 */
	public Controller() {
		
	}
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try{
			handleloginActions();
		} catch(NullPointerException e){}
		try{
			handleAccountHomeActions();
		} catch(NullPointerException e){}
		try{
			handleAccountDetailActions();
		} catch(NullPointerException e){}
		try{
			handlecreateVoteActions();
		} catch(NullPointerException e){}
		try{
			handleEditVoteActions();
		} catch(NullPointerException e){}
		try{
			handleParticipateVoteActions();
		} catch(NullPointerException e){}
		try{
			handleResultsActions();
		} catch(NullPointerException e){}
		try{
			handleVoteDetailsActions();
		} catch(NullPointerException e){}
		try{
			handleVoteListActions();
		} catch(NullPointerException e){}
		try{
			handleVotePageActions();
		} catch(NullPointerException e){}
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleloginActions(){
		login$loginbutton.setOnAction(verifyAndLogin());
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleAccountHomeActions(){
		logoutButton.setOnAction(logoutButtonHandler());
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleAccountDetailActions(){
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handlecreateVoteActions(){
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleEditVoteActions(){
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleParticipateVoteActions(){
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleResultsActions(){
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleVoteDetailsActions(){
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleVoteListActions(){
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleVotePageActions(){
		
	}
	
	/*
	 * Checks if the login details are correct and if so, changes the screen to the home screen
	 */
	private EventHandler<ActionEvent> verifyAndLogin(){
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
	 * Registers an account with the details in thetextfields
	 */
	private EventHandler<ActionEvent> register(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
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
	 * Changes the current scene to the account details scene
	 */
	private EventHandler<ActionEvent> accountDetailsButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * changes the scene to the create vote scene
	 */
	private EventHandler<ActionEvent> createVoteButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * Changes the current scene to view votes and details
	 */
	private EventHandler<ActionEvent> viewVotesButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * Changes the scene to the previous scene
	 */
	private EventHandler<ActionEvent> backButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * resets the password
	 */
	private EventHandler<ActionEvent> resetPasswordHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * Saves the account details
	 */
	private EventHandler<ActionEvent> accountDetailsSaveButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * a handler for the add question button in create vote scene
	 */
	private EventHandler<ActionEvent> addQuestionButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * a handler for the view questions button in create vote scene
	 */
	private EventHandler<ActionEvent> viewQuestionButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * a handler for the delete question button
	 */
	private EventHandler<ActionEvent> deleteQuestionButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * create vote save button handler
	 */
	private EventHandler<ActionEvent> createVoteSaveButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
	
	/*
	 * finish button handler for vote details screen
	 */
	private EventHandler<ActionEvent> voteDetailsFinishButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				
			}
		};
		return event;
	}
}