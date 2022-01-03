package application;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;

public class selectionsort extends animation
{
	

	
	

	public selectionsort()
	{
	  	
	}
	
	
	
	/*
     * ---------------------Bubble Sort algorithm----------------------------- 
     */
	/**
     * Bubble Sort algorithm
	 * @throws InterruptedException 
     */
	protected Task<Void> selectionsortTask(ObservableList<Data<String, Number>> bars)
	{   
		return new Task<Void>()
				{

					@Override
					protected Void call() throws Exception 
					{
						// TODO Auto-generated method stub
											
						for(int i = bars.size()-1; i>0; i--)
						{
							int largestindex = 0;
							Data<String, Number> largest = null;
						
							for(int j = 1; j<=i; j++ )
							{
							    Data<String, Number> first = bars.get(j);
							    largest = bars.get(largestindex);
							    
								prestyleset(first, largest);
								
								if(getval(first)>getval(largest))
								{
									largestindex = j;
								}
								
							}
							
							Data<String,Number> last = bars.get(i);
							largest = bars.get(largestindex);
							
							visualizeswap(largest, last);
							
                      		poststyleset(largest, last);
                      		
                      		
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
