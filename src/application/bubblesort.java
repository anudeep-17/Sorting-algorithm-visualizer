package application;

import java.util.concurrent.CountDownLatch;

import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;
import javafx.util.Duration;

public class bubblesort extends animation
{
	
	
	public bubblesort()
	{
	  	
	}
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
					    		   
	      			     		  prestyleset(first, second);
			    		   
					    		   if(getval(first) > getval(second))
					    		   {
					    			   visualizeswap(first, second);
					    		   }
					    		   					    		    
					    		 //once set in right place, change of color.
					    		   poststyleset(first, second);		

					    		   
					    	   }
					    	   
                                //to set the first bar in sorted position.
					    	   bars.get(0).getNode().setStyle("-fx-background-color: green;");
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
