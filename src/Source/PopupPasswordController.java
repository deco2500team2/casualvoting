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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class PopupPasswordController implements Initializable{
	/*
	 * Instance variables:
	 */
	
	/* The GUI components from the FXML file */
	@FXML
	private Button saveButton;
	@FXML
	private TextField popupPassword$currentPWord;
	@FXML
	private TextField popupPassword$newPWord;
	@FXML
	private TextField popupPassword$newPasswordRepeat;
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleAccountDetailActions();
	}
	
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleAccountDetailActions(){
		saveButton.setOnAction(saveButtonHandler());
	}
	
	/*
	 * Changes the scene to the reset password scene
	 */
	private EventHandler<ActionEvent> saveButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				System.out.println("got here");
				DataBase.userAccount.password = popupPassword$newPWord.getText();
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.close();
			}
		};
		return event;
	}
	
}