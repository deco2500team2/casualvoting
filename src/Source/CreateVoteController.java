package Source;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class CreateVoteController implements Initializable{
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
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handlecreateVoteActions();
	}
	
	public void handlecreateVoteActions() {
		
	}
	
	
	
}