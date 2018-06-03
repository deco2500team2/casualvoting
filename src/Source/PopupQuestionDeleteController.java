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

public class PopupQuestionDeleteController implements Initializable {
	/*
	 * Instance variables:
	 */
	
	/* The GUI components from the FXML file */
	@FXML
	private Button deleteButton;
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
		deleteButton.setOnAction(deleteButtonHandler());
		
	}
	
	private EventHandler<ActionEvent> deleteButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				String selected = listview.getSelectionModel().getSelectedItem();
				for(int i=0; i<listview.getItems().size(); i++){
					if(listview.getItems().get(i).equals(selected)){
						listview.getItems().remove(i);
					}
				}
				for(int i=0; i<DataBase.currentQuestions.size(); i++){
					if(DataBase.currentQuestions.get(i).questionTitle.equals(selected)){
						DataBase.currentQuestions.remove(i);
					}
				}
			}
		};
		return event;
	}
	
}
