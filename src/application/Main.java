package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	//pre-coded which runs the program,
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	
	  
	@Override
	
	public void start(Stage primaryStage) 
	{
		try 
		{
			primaryStage.setTitle("Algorithm visualizer");
			
			BorderPane pane = new BorderPane();
			
			pane.setPadding(new Insets(10));
			
			
			//instants the object with all the code of visualizer
		    visualizer algorithm_visualizer = new visualizer(pane);
		   
		    
		    
		    Scene scene = new Scene(pane);
		    
			//preset
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
    
    
    
    

    
    
}
