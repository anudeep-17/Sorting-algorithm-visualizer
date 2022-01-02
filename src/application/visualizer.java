package application;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class visualizer extends bubblesort
{

	
	visualizer(BorderPane pane)
	{
		chartmaker(pane);
		Objectcreator(pane);
	}

	
	
	
	
	//..........................code starts here ................................................
	
	 ObservableList<Data<String, Number>> bars;
	  BarChart<String, Number> barchart1;
	  FlowPane objectorientator; 
	  Random rand =  new Random();
	  
      ExecutorService serv = Executors.newCachedThreadPool(runnable -> 
      {
    	  Thread t = new Thread(runnable);
    	  t.setDaemon(true);
    	  return t;
      });
      
	  

	//chart is made here ------
    public void chartmaker(BorderPane pane)
	{
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		
	    barchart1 = new BarChart<String, Number>(xAxis, yAxis);
	   
	    barchart1.setAnimated(false);

	    barchart1.setLegendVisible(false);
        barchart1.getYAxis().setTickLabelsVisible(false);
        barchart1.getYAxis().setOpacity(0);
        barchart1.getXAxis().setTickLabelsVisible(false);
        barchart1.getXAxis().setOpacity(0);
        barchart1.setHorizontalGridLinesVisible(false);
        barchart1.setVerticalGridLinesVisible(false);
        
       
       bars = FXCollections.observableArrayList(); //instantiating the bars 
       fillindata(); // filling data into the bar graph and setting the chart for user.
       barchart1.getData().add(new Series<>(bars)); //adding them to the barchart
       
      
    
       pane.setCenter(barchart1);
       
	}
    
    
    
    
  //object creator method that helps the in creating the buttons and text fields.
	public void Objectcreator(BorderPane pane)
	{
	
		objectorientator = new FlowPane();
		objectorientator.setHgap(10);
		objectorientator.setVgap(10);
		
	    Buttoncreate("RESET" , () -> resetvalues(pane));		
		bubblesortbuttoncreate(bubblesortTask(bars));
		
		pane.setBottom(objectorientator);
		
	}
	
	//button creator method takes name of button and runnable method.
	private void Buttoncreate(String nameofbutton, Runnable method)
	{
		// TODO Auto-generated method stub
		Button create = new Button(nameofbutton);
		create.setOnAction(event -> method.run());
		objectorientator.getChildren().add(create);
	}
	
	private void bubblesortbuttoncreate(Runnable method)
	{
		Button createButton = new Button("bubblesort");
		createButton.setOnAction(e ->
		{
			Task<Void> animatedSort = (Task<Void>) method;
			serv.submit(animatedSort);
			
		});
		
		objectorientator.getChildren().add(createButton);
	}
	
	
	
	
	
	//reseting the graph by running with new values.
	public void resetvalues(BorderPane pane)
	{
		chartmaker(pane);
	}
	
	
	//creating random values and filling array
	public int randomnum_forgraphing()
	{
		return rand.nextInt(100)+1;
	}
	
	
	
	//filling data in observable list to work on bar chart in method chartmaker()
    public void fillindata()
    {
    	 for(int i = 0; i < 10; i++)
		   {
			   Data<String, Number> dataObject = new Data<>(Integer.toString(i + 1), randomnum_forgraphing());
			   bars.add(dataObject);
		   }
    	 
    }
    
    
    
    
    
	
}
