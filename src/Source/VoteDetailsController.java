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
public class VoteDetailsController implements Initializable{
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
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleVoteDetailsActions();
	}

	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleVoteDetailsActions(){
		
	}
}