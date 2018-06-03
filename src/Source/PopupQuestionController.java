package Source;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class PopupQuestionController implements Initializable{
	/*
	 * Instance variables:
	 */
	
	/* The GUI components from the FXML file */
	@FXML
	private Button saveButton;
	@FXML
	private TextField popupPassword$currentPWord;
	@FXML
	private Button addAnswer;
	@FXML
	private Button deleteAnswer;
	@FXML
	private ChoiceBox<String> choicebox;
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
		choicebox.getItems().addAll("MultiChoice", "Written Responce");
		if(DataBase.loadQuestion){
			String value = DataBase.currentQuestion.questionTitle;
			popupPassword$currentPWord.setText(value);
			choicebox.getSelectionModel().select(0);
			for(String answer: DataBase.currentQuestion.answers.keySet() ){
				listview.getItems().add(answer);
			}
		}
		
		handleAccountDetailActions();
		
		DataBase.loadQuestion = false;
	}
	
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleAccountDetailActions(){
		saveButton.setOnAction(saveButtonHandler());
		addAnswer.setOnAction(addAnswerHandler());
		listview.getSelectionModel().selectedItemProperty().addListener(listSelectionHandler());
		deleteAnswer.setOnAction(deleteAnswerHandler());
	}
	
	private ChangeListener<String> listSelectionHandler(){
		ChangeListener<String> handler = new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldValue, String answername) {
				
			}
			
		};
		return handler;
	}
	
	private EventHandler<ActionEvent> addAnswerHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("popupAnswer.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = new Stage();
					window.setScene(nextScene);
					window.showAndWait();
					listview.getItems().add(DataBase.currentAnswer);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		return event;
	}
	
	private EventHandler<ActionEvent> deleteAnswerHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				String selected = listview.getSelectionModel().getSelectedItem();
				for(int i=0; i<listview.getItems().size(); i++){
					if(listview.getItems().get(i).equals(selected)){
						listview.getItems().remove(i);
					}
				}
			}
		};
		return event;
	}
	
	private EventHandler<ActionEvent> saveButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				Question q = new Question();
				q.questionTitle = popupPassword$currentPWord.getText();
				for(String s:listview.getItems()){
					q.answers.put(s, 0);
				}
				DataBase.currentQuestions.add(q);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.close();
			}
		};
		return event;
	}
	
}