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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PopupQuestionListController implements Initializable {
	/*
	 * Instance variables:
	 */
	
	/* The GUI components from the FXML file */
	@FXML
	private Button saveButton;
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
		List<String> questionNames = new ArrayList<String>();
		for(Question q:DataBase.currentQuestions){
			questionNames.add(q.questionTitle);
		}
		listview.getItems().setAll(questionNames);
		
		handleAccountDetailActions();
		
	}
	
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleAccountDetailActions(){
		saveButton.setOnAction(saveButtonHandler());
		listview.getSelectionModel().selectedItemProperty().addListener(listSelectionHandler());
	}
	
	private ChangeListener<String> listSelectionHandler(){
		ChangeListener<String> handler = new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldValue, String questionName) {
				//set the current question
				//change scene
				for(int i=0; i<DataBase.currentQuestions.size(); i++){
					if(questionName.equals(DataBase.currentQuestions.get(i).questionTitle)){
						DataBase.currentQuestion = DataBase.currentQuestions.get(i);
					}
					
				}
				
				//Set to loat the question
				DataBase.loadQuestion = true;
				try {
					Parent p = FXMLLoader.load(getClass().getResource("popupQuestion.fxml"));
					Scene nextScene = new Scene(p);
					Stage window = new Stage();
					window.setScene(nextScene);
					window.showAndWait();
					
					Stage window2 = (Stage)(listview.getScene().getWindow());
					window2.close();
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		return handler;
	}
	
	private EventHandler<ActionEvent> saveButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.close();
			}
		};
		return event;
	}
}
