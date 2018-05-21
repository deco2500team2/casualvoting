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
	private Button backButton;
	@FXML
	private Button home$accountDetailsButton;
	@FXML
	private Button home$createVoteButton;
	@FXML
	private Button home$viewVoteAndDetailsButton;
	@FXML
	private ListView home$recommendedVotesListView;
	
	
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