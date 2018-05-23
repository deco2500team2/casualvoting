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
	private Button saveButton;
	@FXML
	private PieChart popupQuestionResult$pieChart;
	@FXML
	private BarChart<?, ?> barChart;
	
	
	
	/**
	 * A method to handle the GUI initialisation.
	 * 
	 * @param location The location of the root object.
	 * @param resources The resources to localise the root.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		handleResultsActions();
		
		/*
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
		for(String k : DataBase.currentQuestion.answers.keySet()){
			pieChartData.add(new PieChart.Data(k, DataBase.currentQuestion.answers.get(k)));
		}
		

        PieChart chart = new PieChart(pieChartData);
        chart.setTitle(DataBase.currentQuestion.questionTitle);
        popupQuestionResult$pieChart = chart;
        */
		
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");
        popupQuestionResult$pieChart = chart;
		
        
		System.out.println("Got to the end");
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