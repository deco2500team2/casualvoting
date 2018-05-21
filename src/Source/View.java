package Source;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class View {

	Stage primaryStage;
	
	final double SCREENWIDTH = 400;
	final double SCREENHEIGHT = 300;
	
	Scene loginScene;
	Scene registerScene;
	Scene homeScene;
	Scene accountDetailsScene;
	Scene createVoteScene;
	Scene voteListScene;
	Scene resultsScene;
	Scene participateScene;
	Scene editVoteScene;
	Scene voteScene; //where we have the edit, participate, results buttons
	Scene previousScene; //used for the back button
	
	Button homeButton;
	Button backButton;
	Button logoutButton;
	
	Account account;
	Vote currentvote;
	
	public View(Stage primaryStage) {
		this.primaryStage = primaryStage;
		DataBase.setupDatabase();
		setupScenes();
	}
	
	private void setupScenes() {
		
		homeButton = new Button("Home");
		homeButton.setOnAction(e -> {
			primaryStage.setScene(homeScene);
		});
		
		backButton = new Button("Back");
		backButton.setOnAction(e -> {
			primaryStage.setScene(previousScene);
		});
		
		logoutButton = new Button("Logout");
		logoutButton.setOnAction(e -> {
			primaryStage.setScene(loginScene);
		});
		
		setupLoginScene();
		setupRegisterScene();
		
		
		primaryStage.setScene(loginScene);
		primaryStage.setTitle("Casual Voting");
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> {
			DataBase.saveDatabase();
		});
	}

	private void setupVoteScene() {
		Label pagetitle = new Label("Vote");//("+currentvote.votename+")");
		Button editvoteButton = new Button("Edit Vote");
		Button participateButton = new Button("Participate");
		Button viewResultsButton = new Button("View Results");
		Button saveButton = new Button("Save & Finish");
		editvoteButton.setOnAction(e -> {
			
		});
		participateButton.setOnAction(e -> {
			
		});
		viewResultsButton.setOnAction(e -> {
			
		});
		saveButton.setOnAction(e -> {
				
		});
		HBox sub3 = new HBox();
		sub3.getChildren().addAll(homeButton, pagetitle, logoutButton);
		HBox sub2 = new HBox();
		sub2.getChildren().addAll(editvoteButton, participateButton, viewResultsButton);
		HBox sub1 = new HBox();
		sub1.getChildren().addAll(backButton, saveButton);
		VBox root = new VBox();
		root.getChildren().addAll(sub3, sub2, sub1);
		voteScene = new Scene(root, SCREENWIDTH, SCREENHEIGHT);
	}

	private void setupParticipateScene() {
		// TODO Auto-generated method stub
		
	}

	private void setupResultsScene() {
		// TODO Auto-generated method stub
		
	}

	private void setupVoteListScene() {
		Label pagetitle = new Label("Votes");
		Label listofvotes = new Label("List of Votes");
		Label filterOptions = new Label("Filter options");
		
		Button filter1 = new Button("Your Created Votes");
		Button filter2 = new Button("All Votes");
		Button filter3 = new Button("Participated Votes");
		Button filter4 = new Button("Public Votes");
		Button filter5 = new Button("Private Votes");
		Button searchButton = new Button("Search");
		
		TextField searchbar = new TextField();
		
		ListView<String> listview = new ListView<String>();
		List<String> votenames = new ArrayList<String>();
		for(Vote v:DataBase.votes){
			votenames.add(v.votename);
		}
		listview.getItems().setAll(votenames);
		
		HBox sub6 = new HBox();
		sub6.getChildren().addAll(searchbar, searchButton);
		VBox sub4 = new VBox();
		sub4.getChildren().addAll(listofvotes, sub6, listview);
		VBox sub5 = new VBox();
		sub5.getChildren().addAll(filterOptions, filter1, filter2, filter3, filter4, filter5);
		HBox sub1 = new HBox();
		sub1.getChildren().addAll(homeButton, pagetitle, logoutButton);
		HBox sub2 = new HBox();
		sub2.getChildren().addAll(sub4, sub5);
		HBox sub3 = new HBox();
		sub3.getChildren().addAll(backButton);
		VBox root = new VBox();
		root.getChildren().addAll(sub1, sub2, sub3);
		voteListScene = new Scene(root, SCREENWIDTH, SCREENHEIGHT);
		
	}

	private void setupCreateVoteScene() {
		Label pagetitle = new Label("Create Vote");
		Label votetitle = new Label("Vote Title:");
		Label votedescription = new Label("Description:");
		
		Button homeButton = new Button("Home");
		Button logoutButton = new Button("Logout");
		Button addQuestionButton = new Button("Add Question");
		Button viewQuestionsButton = new Button("View Questions");
		Button voteDetailsButton = new Button("Vote Details");
		Button cancleButton = new Button("Cancel");
		Button nextButton = new Button("Next");
		
		TextField votetitletextfield = new TextField();
		TextField votedescriptiontextfield = new TextField();
		
		HBox sub1 = new HBox();
		sub1.getChildren().addAll(homeButton, pagetitle, logoutButton);
		GridPane grid = new GridPane();
		grid.add(votetitle, 0, 0);
		grid.add(votedescription, 0, 1);
		grid.add(votetitletextfield, 1, 0);
		grid.add(votedescriptiontextfield, 1, 1);
		HBox sub2 = new HBox();
		sub2.getChildren().addAll(addQuestionButton, viewQuestionsButton, voteDetailsButton);
		HBox sub3 = new HBox();
		//sub3.getChildren().addAll(c)
		VBox root = new VBox();
		createVoteScene = new Scene(root, SCREENWIDTH, SCREENHEIGHT);
	}

	private void setupAccountDetailsScene() {
		Label pagetital = new Label("Account Details");
		Label firstnameLabel = new Label();
		Label surnameLabel = new Label();
		Label titleLabel = new Label();
		Label dobLabel = new Label();
		Label emailLabel = new Label();
		firstnameLabel.setText("Given name: "+account.firstname);
		surnameLabel.setText("Surname: "+account.surname);
		titleLabel.setText("Title: "+account.title);
		dobLabel.setText("Date of Birth: "+account.DoB);
		emailLabel.setText("Email: "+account.email);
		
		Button resetPassword = new Button("Reset Password");
		resetPassword.setOnAction(e -> {
			
		});
		Button saveButton = new Button("Save");
		saveButton.setOnAction(e -> {
			
		});
		HBox sublayout3 = new HBox();
		sublayout3.getChildren().addAll(homeButton, pagetital, logoutButton);
		VBox sublayout2 = new VBox();
		sublayout2.getChildren().addAll(firstnameLabel,surnameLabel, titleLabel, dobLabel, emailLabel, resetPassword);
		HBox sublayout1 = new HBox();
		sublayout1.getChildren().addAll(backButton, saveButton);
		VBox root = new VBox();
		root.getChildren().addAll(sublayout3, sublayout2, sublayout1);
		accountDetailsScene = new Scene(root, SCREENWIDTH, SCREENHEIGHT);
	}

	private void setupHomeScene() {
		Label pagetital = new Label("Account Home");
		Label recommendedVotesLabel = new Label("Recommended Votes");
		Label informationLabel = new Label("Had 28 people participate in your votes since your last vist."+System.lineSeparator()+ "You last Participated in a vote 2 days ago.");
		
		//have a list view of recommended votes, no need to implement now as time constraints
		ListView<String> listview = new ListView<String>();
		List<String> votenames = new ArrayList<String>();
		for(Vote v:DataBase.votes){
			votenames.add(v.votename);
		}
		listview.getItems().setAll(votenames);
		
		Line line = new Line(SCREENWIDTH/2, 0.1*SCREENHEIGHT, SCREENWIDTH/2, 0.9*SCREENHEIGHT);
		line.setFill(Color.BLUE);
		Line line2 = new Line(0.6*SCREENWIDTH, SCREENHEIGHT/3, 0.9*SCREENWIDTH, SCREENHEIGHT/3);
		line2.setFill(Color.BLUE);
				
		Button accountDetailsButton = new Button("Account Details");
		Button createVoteButton = new Button("Account Details");
		Button viewVotesButton = new Button("View Votes & Details");
		accountDetailsButton.setOnAction(e -> {
			previousScene = homeScene;
			primaryStage.setScene(accountDetailsScene);
		});
		createVoteButton.setOnAction(e -> {
			previousScene = homeScene;
			primaryStage.setScene(createVoteScene);
		});
		viewVotesButton.setOnAction(e -> {
			previousScene = homeScene;
			primaryStage.setScene(voteListScene);
		});
		VBox sublayout3 = new VBox();
		sublayout3.getChildren().addAll(accountDetailsButton, createVoteButton, viewVotesButton);
		VBox sublayout2 = new VBox();
		sublayout2.getChildren().addAll(recommendedVotesLabel, listview, line2, informationLabel);
		HBox sublayout1 = new HBox();
		sublayout1.getChildren().addAll(sublayout3, line, sublayout2);
		HBox sublayout = new HBox();
		sublayout.getChildren().addAll(homeButton, pagetital, logoutButton);
		VBox root = new VBox();
		root.getChildren().addAll(sublayout, sublayout1);
		homeScene = new Scene(root, SCREENWIDTH, SCREENHEIGHT);
		
	}

	private void setupRegisterScene() {
		TextField usernameTextField = new TextField();
		usernameTextField.setPromptText("username");
		TextField passwordTextField = new TextField();
		passwordTextField.setPromptText("password");
		TextField titleTextField = new TextField();
		titleTextField.setPromptText("title");
		TextField firstnameTextField = new TextField();
		firstnameTextField.setPromptText("Firstname");
		TextField surnameTextField = new TextField();
		surnameTextField.setPromptText("surname");
		TextField dobTextField = new TextField();
		dobTextField.setPromptText("Date of Birth");
		TextField emailTextField = new TextField();
		emailTextField.setPromptText("email");
		TextField repeatpasswordTextField = new TextField();
		repeatpasswordTextField.setPromptText("password");
		
		Label usernameLabel = new Label("Username:");
		Label passwordLabel = new Label("Password:");
		Label companyNameLabel = new Label("CasualVoting.com");
		Label helperLabel = new Label("*Please fill out all fields");
		Label titleLabel = new Label("Title");
		Label firstnameLabel = new Label("Given Name");
		Label surnameLabel = new Label("Surname");
		Label dobLabel = new Label("Date of Birth");
		Label emailLabel = new Label("Email ");
		Label repeatpasswordLabel = new Label("Repeat Password");
		
		Line line = new Line(SCREENWIDTH/2, 0.1*SCREENHEIGHT, SCREENWIDTH/2, 0.9*SCREENHEIGHT);
		line.setFill(Color.BLUE);
		
		Button createAccountButton = new Button("Create Account");
		createAccountButton.setOnAction(e -> {
			DataBase.addAccount(usernameTextField.getText(), passwordTextField.getText(), 
					emailTextField.getText(), titleTextField.getText(), firstnameTextField.getText(), 
					surnameTextField.getText(), dobTextField.getText());
			AlertBox.display("Alert!", "Account has been created");
		});
		
		Button loginButton = new Button("Login");
		loginButton.setOnAction(e -> {
			previousScene = registerScene;
			primaryStage.setScene(loginScene);
		});
		
		Button registerButton = new Button("Register");
		GridPane grid = new GridPane();
		
		HBox sublayout = new HBox();
		sublayout.getChildren().addAll(loginButton, registerButton);
		
		grid.add(sublayout, 1, 0);
		grid.add(titleLabel, 0, 1);
		grid.add(firstnameLabel, 0, 2);
		grid.add(surnameLabel, 0, 3);
		grid.add(dobLabel, 0, 4);
		grid.add(emailLabel, 0, 5);
		grid.add(usernameLabel, 0, 6);
		grid.add(passwordLabel, 0, 7);
		grid.add(repeatpasswordLabel, 0, 8);
		grid.add(helperLabel, 0, 9);
		grid.add(titleTextField, 1, 1);
		grid.add(firstnameTextField, 1, 2);
		grid.add(surnameTextField, 1, 3);
		grid.add(dobTextField, 1, 4);
		grid.add(emailTextField, 1, 5);
		grid.add(usernameTextField, 1, 6);
		grid.add(passwordTextField, 1, 7);
		grid.add(repeatpasswordTextField, 1, 8);
		grid.add(createAccountButton, 1, 9);
		
		HBox root = new HBox();
		root.getChildren().addAll(companyNameLabel, line, grid);
		registerScene = new Scene(root, SCREENWIDTH, SCREENHEIGHT);
	}

	private void setupLoginScene() {
		TextField usernameTextField = new TextField();
		usernameTextField.setPromptText("username");
		
		TextField passwordTextField = new TextField();
		passwordTextField.setPromptText("password");
		
		Label usernameLabel = new Label("Username:");
		Label passwordLabel = new Label("Password:");
		Label companyNameLabel = new Label("CasualVoting.com");
		Label helperLabel = new Label("*Please fill out all fields");
		Line line = new Line(SCREENWIDTH/2, 0.1*SCREENHEIGHT, SCREENWIDTH/2, 0.9*SCREENHEIGHT);
		line.setFill(Color.BLUE);
		
		Button loginButton = new Button("login");
		loginButton.setOnAction(e -> {
			String username = usernameTextField.getText();
			String password = passwordTextField.getText();
			Account account = DataBase.checkLogin(username, password);
			if(account == null){
				AlertBox.display("Alert!", "Incorrect username or password");
			} else{
				previousScene = loginScene;
				this.account = account;
				setupHomeScene();
				setupAccountDetailsScene();
				setupCreateVoteScene();
				setupVoteListScene();
				setupResultsScene();
				setupParticipateScene(); 
				setupVoteScene();
				primaryStage.setScene(homeScene);
			}
		});
		
		Button registerButton = new Button("Register");
		registerButton.setOnAction(e -> {
			previousScene = loginScene;
			primaryStage.setScene(registerScene);
		});
		Button toLoginButton = new Button("Login");
		
		HBox sublayout2 = new HBox();
		sublayout2.getChildren().addAll(toLoginButton, registerButton);
		VBox sublayout1 = new VBox();
		sublayout1.getChildren().addAll(sublayout2, usernameLabel, 
				usernameTextField, passwordLabel, passwordTextField, helperLabel, loginButton);
		HBox rootlayout = new HBox();
		rootlayout.getChildren().addAll(companyNameLabel, line, sublayout1);
		
		loginScene = new Scene(rootlayout, SCREENWIDTH, SCREENHEIGHT);
		
	}

}
