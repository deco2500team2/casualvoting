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
public class ResultsController implements Initializable{
	/*
	 * Instance variables:
	 */
	
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
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleResultsActions();
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleResultsActions(){
		
	}
}