package application;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;
import javafx.util.Duration;

public class bubblesort extends animation
{
	
	
	

	
	
	
	
	
	/*
     * ---------------------Bubble Sort algorithm----------------------------- 
     */
	/**
     * Bubble Sort algorithm
	 * @throws InterruptedException 
     */
	protected Task<Void> bubblesortTask(ObservableList<Data<String, Number>> bars)
	{   
		return new Task<Void>()
				{

					@Override
					protected Void call() throws Exception 
					{
						// TODO Auto-generated method stub
						for(int i = 0; i < bars.size(); i++ )
					       {
					    	   for(int j = 0; j < (bars.size()-i)-1 ; j++)
					    	   {
					    		   Data<String, Number> first = bars.get(j);
					    		   Data<String, Number> second = bars.get(j+1);
					    		   
	      			    		   Platform.runLater(() ->
					    		   {
					    			   first.getNode().setStyle("-fx-background-color: black ;");
					    			   second.getNode().setStyle("-fx-background-color: black ;");
					    			   
					    		   });
					    		   
					    		   Thread.sleep(50);
					    		   
					    		   if(getval(first) > getval(second))
					    		   {
					    			   CountDownLatch latch = new CountDownLatch(1);
					    			   Platform.runLater(() ->
					    			   {
					    				Animation swap = swap(first, second);
					    				swap.setOnFinished(e -> latch.countDown());
					    				swap.play();
					    			   
					    			   });
					    			   latch.await();
					    		   }
					    		   
					    		   Thread.sleep(50);
					    		   
					    		   int forcolorchange = j;
					    		   int indexoflastrun = bars.size()-i-2;
					    		   
					    		   Platform.runLater(() -> {
					    			   
					                   first.getNode().setStyle(" ");
					                   second.getNode().setStyle("-fx-background-color: green;");
					                   if(forcolorchange == indexoflastrun)
							    	   {
							    		   first.getNode().setStyle("-fx-background-color: green;");
							    	   }
					               });
					    		   
					    	   }
					    	  
					    	
					    	   
					       }
						 
						return null;
					}
			
				};
	 
	}

    private double getval(Data<String, Number> given)
    {
    	return given.getYValue().doubleValue();
    }

   
   
		   
   
}
