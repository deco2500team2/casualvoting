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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the voting application.
 * @author Simon Curtis
 */
public class LoginController implements Initializable{
	/*
	 * Instance variables:
	 */
	
	/* The GUI components from the FXML file */
	@FXML
	private Button login$loginbutton;
	@FXML
	private Button login$registerButton;
	@FXML
	private TextField login$usernameTextField;
	@FXML
	private PasswordField login$passwordTextField;
	@FXML
	private ComboBox<String> login$titleDropdown;
	@FXML
	private TextField login$firstnameTextField;
	@FXML
	private TextField login$surnameTextField;
	@FXML
	private TextField login$dobTextField;
	@FXML
	private TextField login$emailTextField;
	@FXML
	private TextField login$otherUsernameTextField;
	@FXML
	private PasswordField login$otherPasswordTextField;
	@FXML
	private PasswordField login$repeatPasswordTextField;
	@FXML
	private Button homeButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button backButton;
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleloginActions();
		login$titleDropdown.getItems().addAll("Miss", "Mr", "Mrs", "Ms", "Dr");
	}
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleloginActions(){
		login$loginbutton.setOnAction(verifyAndLogin());
		login$registerButton.setOnAction(register());
	}

	/*
	 * Checks if the login details are correct and if so, changes the screen to the home screen
	 */
	private EventHandler<ActionEvent> verifyAndLogin(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				String username = login$usernameTextField.getText();
				String password = login$passwordTextField.getText();
				Account account = DataBase.checkLogin(username, password);
				System.out.println(username);System.out.println(password);
				
				
				if(account == null){
					AlertBox.display("Alert!", "Incorrect username or password");
				} else{
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
			}
		};
		return event;
	}
	
	/*
	 * Registers an account with the details in thetextfields
	 */
	private EventHandler<ActionEvent> register(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				DataBase.addAccount(login$otherUsernameTextField.getText(), login$otherPasswordTextField.getText(), 
						login$emailTextField.getText(), login$titleDropdown.getSelectionModel().getSelectedItem(), login$firstnameTextField.getText(), 
						login$surnameTextField.getText(), login$dobTextField.getText());
				AlertBox.display("Alert!", "Account has been created");
			}
		};
		return event;
	}
	
	
}