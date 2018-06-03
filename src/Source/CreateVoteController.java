package Source;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class CreateVoteController implements Initializable{
	/*
	 * Instance variables:
	 */
	List<Question> questions;
	
	/* The GUI components from the FXML file */
	@FXML
	private Button homeButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button backButton;
	
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
	private TextArea createVote$descriptionTextField;
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handlecreateVoteActions();
		DataBase.currentQuestions = new ArrayList<Question>();
	}
	
	public void handlecreateVoteActions() {
		homeButton.setOnAction(homeButtonHandler());
		logoutButton.setOnAction(logoutButtonHandler());
		backButton.setOnAction(homeButtonHandler());
		createVote$saveButton.setOnAction(saveButtonHandler());
		createVote$viewQuestionButton.setOnAction(viewButtonHandler());
		createVote$addQuestionButton.setOnAction(addQuestionButtonHandler());
		createVote$deleteQuestionButton.setOnAction(deleteQuestionHandler());
	}
	
	private EventHandler<ActionEvent> addQuestionButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("popupQuestion.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = new Stage();
					window.setScene(nextScene);
					window.showAndWait();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		return event;
	}
	
	
	private EventHandler<ActionEvent> saveButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				if(createVote$voteTitleTextField.getText()==null||createVote$voteTitleTextField.getText().equals("")){
					AlertBox.display("Alert!", "Please enter a vote title");
				}else{
					DataBase.addVote(createVote$voteTitleTextField.getText(), DataBase.userAccount, createVote$descriptionTextField.getText());
					DataBase.currentVote = DataBase.getVote(createVote$voteTitleTextField.getText());
					DataBase.currentVote.questions = DataBase.currentQuestions;
					try {
						Parent p = FXMLLoader.load(getClass().getResource("voteDetails.fxml"));
						Scene nextScene = new Scene(p);
						Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
						window.setScene(nextScene);
						window.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
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
	
	private EventHandler<ActionEvent> viewButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("popupQuestionList.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = new Stage();
					window.setScene(nextScene);
					window.showAndWait();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		return event;
	}
	
	private EventHandler<ActionEvent> deleteQuestionHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("popupQuestionDelete.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = new Stage();
					window.setScene(nextScene);
					window.showAndWait();
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