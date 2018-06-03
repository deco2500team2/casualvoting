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
public class AccountDetailsController implements Initializable{
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
	private Button accountDetails$resetPasswordButton;
	@FXML
	private ComboBox<String> accountDetails$titleDropdown;
	@FXML
	private TextField accountDetails$firstnameTextField;
	@FXML
	private TextField accountDetails$surnameTextField;
	@FXML
	private TextField accountDetails$dobTextField;
	@FXML
	private TextField accountDetails$emailTextField;
	@FXML
	private TextField accountDetails$usernameTextField;
	@FXML
	private Button accountDetails$saveButton;
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleAccountDetailActions();
		
		accountDetails$titleDropdown.getItems().addAll("Miss", "Mr", "Mrs", "Ms","Dr");
		accountDetails$firstnameTextField.setText(DataBase.userAccount.firstname);
		accountDetails$surnameTextField.setText(DataBase.userAccount.surname);
		accountDetails$dobTextField.setText(DataBase.userAccount.DoB);
		accountDetails$emailTextField.setText(DataBase.userAccount.email);
		accountDetails$usernameTextField.setText(DataBase.userAccount.username);
		
		//Set the default value to be the one selected by the user
		int index = -1;
		for (int i=0; i<accountDetails$titleDropdown.getItems().size(); i++){
			if(accountDetails$titleDropdown.getItems().get(i).equals(DataBase.userAccount.title)){
				index = i;
			}
		}
		
		System.out.println(DataBase.userAccount.title);
		accountDetails$titleDropdown.getSelectionModel().select(index);
	}
	
	
	/*
	 * A method to create all of the button handlers for the login scene.
	 */
	private void handleAccountDetailActions(){
		homeButton.setOnAction(homeButtonHandler());
		logoutButton.setOnAction(logoutButtonHandler());
		backButton.setOnAction(homeButtonHandler());
		accountDetails$saveButton.setOnAction(saveButtonHandler());
		accountDetails$resetPasswordButton.setOnAction(resetPasswordButtonHandler());
	}
	
	/*
	 * Changes the scene to the reset password scene
	 */
	private EventHandler<ActionEvent> resetPasswordButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				try {
					Parent p = FXMLLoader.load(getClass().getResource("popupPassword.fxml"));
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
	 * Changes the scene to the home scene
	 */
	private EventHandler<ActionEvent> saveButtonHandler(){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				DataBase.userAccount.firstname = accountDetails$firstnameTextField.getText();
				DataBase.userAccount.surname = accountDetails$surnameTextField.getText();
				DataBase.userAccount.title = accountDetails$titleDropdown.getSelectionModel().getSelectedItem();
				DataBase.userAccount.DoB = accountDetails$dobTextField.getText();
				DataBase.userAccount.email = accountDetails$emailTextField.getText();
				DataBase.userAccount.username = accountDetails$usernameTextField.getText();
				AlertBox.display("Alert!", "Your Changes have been saved");
			}
		};
		return event;
	}
	
	
	/*
	 * Changes the scene to the home scene
	 */
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