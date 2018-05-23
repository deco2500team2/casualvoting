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
public class PopupQuestionResult implements Initializable{
	/*
	 * Instance variables:
	 */
	@FXML
	private Button saveButton;
	
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
		
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleResultsActions(){
		saveButton.setOnAction(saveButtonHandler());
	}
	
	
	/*
	 * Changes the scene to the home scene
	 */
	private EventHandler<ActionEvent> saveButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				System.out.println("Clicked button");
			}
		};
		return event;
	}
}