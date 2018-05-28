package Source;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.chart.*;

/**
 * Controller class for the voting application.
 * @author Alexandra Crawley
 */
public class PopupQuestionResult implements Initializable{
	/*
	 * Instance variables:
	 */
	@FXML
	private Label popupQuestionResult$questionLabel;
	@FXML
	private Button saveButton;
	@FXML
	private PieChart popupQuestionResult$pieChart;
	@FXML
	private BarChart<String,Number> popupQuestionResult$barChart;
	
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleResultsActions();
		
		
		popupQuestionResult$questionLabel.setText("Question: "+ DataBase.currentQuestion.questionTitle);
		Boolean flag = true;
		
		XYChart.Series series1 = new XYChart.Series();
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
		for(String k : DataBase.currentQuestion.answers.keySet()){
			if(DataBase.currentQuestion.answers.get(k)!=0){
				pieChartData.add(new PieChart.Data(k, DataBase.currentQuestion.answers.get(k)));
				series1.getData().add(new XYChart.Data(k, DataBase.currentQuestion.answers.get(k)));
				flag = false;
			}
		}
		if(flag){
			pieChartData.add(new PieChart.Data("No results yet!", 1));
		}
		

		popupQuestionResult$pieChart.setData(pieChartData);
        popupQuestionResult$barChart.getData().add(series1);
        popupQuestionResult$barChart.setLegendVisible(false);
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
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.close();
			}
		};
		return event;
	}
}