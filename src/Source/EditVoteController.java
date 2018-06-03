package Source;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class EditVoteController implements Initializable{
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
	private TextArea editVote$descriptionTextArea;
	
	private String previousVoteName;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handlecreateVoteActions();
		
		previousVoteName = DataBase.currentVote.votename;
		
		editVote$voteTitleTextField.setText(previousVoteName);
		if(DataBase.currentVote.description==null){
			editVote$descriptionTextArea.setText("");
		}else{
			editVote$descriptionTextArea.setText(DataBase.currentVote.description);
		}
		
		
		DataBase.currentQuestions = DataBase.currentVote.questions;
		
		
	}
	
	public void handlecreateVoteActions() {
		homeButton.setOnAction(homeButtonHandler());
		logoutButton.setOnAction(logoutButtonHandler());
		backButton.setOnAction(homeButtonHandler());
		editVote$saveButton.setOnAction(saveButtonHandler());
		editVote$viewQuestionButton.setOnAction(viewButtonHandler());
		editVote$addQuestionButton.setOnAction(addQuestionButtonHandler());
		editVote$deleteQuestionButton.setOnAction(deleteQuestionHandler());
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
				if(editVote$voteTitleTextField.getText()==null||editVote$voteTitleTextField.getText().equals("")){
					AlertBox.display("Alert!", "Please enter a vote title");
				}else{
					if(previousVoteName.equals(editVote$voteTitleTextField.getText())){
						DataBase.updateVote(editVote$voteTitleTextField.getText(), DataBase.userAccount, editVote$descriptionTextArea.getText());
					}else{
						DataBase.addVote(editVote$voteTitleTextField.getText(), DataBase.userAccount, editVote$descriptionTextArea.getText());
					}
					
					DataBase.currentVote = DataBase.getVote(editVote$voteTitleTextField.getText());
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