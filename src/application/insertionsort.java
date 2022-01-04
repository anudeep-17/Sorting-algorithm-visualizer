/**
 * 
 */
package application;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;

/**
 * @author Owner
 *
 */
public class insertionsort extends animation
{
	
	public insertionsort()
	{
		//empty constructor.
	}
	
	/*
     * --------------------- insertion Sort algorithm ----------------------------- 
     */
	/**
     * insertion Sort algorithm
	 * @throws InterruptedException 
     */
	
	
	protected Task<Void> insertionsortTask(ObservableList<Data<String, Number>> bars)
	{   
		return new Task<Void>()
				{

					@Override
					protected Void call() throws Exception 
					{
						// TODO Auto-generated method stub
						
						
						//to set the first bar in sorted position.
				    	 bars.get(0).getNode().setStyle("-fx-background-color: green;");
				    	 
						for(int i = 1; i<bars.size(); i++)
						{
							
							double newelement = getval(bars.get(i));
							
							int j;
							
							Data<String, Number> first = null;
							Data<String, Number> second =null;
							
							for(j= i ; j>0 && (getval(bars.get(j-1)) > newelement); j--)
							{
								first = bars.get(j);
								second = bars.get(j-1);
								
								prestyleset(first, second);
								
								visualizeswap(first, second);
								
								poststyleset_forinsertionsort(first, second);
								
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
