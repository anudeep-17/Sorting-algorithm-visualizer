package application;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;

public class shellsort extends animation
{
	
	public shellsort()
	{
		//empty constructor
		
	}
	
	
	/*
     * ---------------------Shell Sort algorithm----------------------------- 
     */
	
	/**
     * shell Sort algorithm
	 * @throws InterruptedException 
     */
	
	protected Task<Void> shellsortTask(ObservableList<Data<String, Number>> bars)
	{   
		return new Task<Void>()
				{

					@Override
					protected Void call() throws Exception 
					{
						// TODO Auto-generated method stub
						for(int gap = (bars.size())/2 ; gap > 0 ; gap/=2 )
						{
							int j = 0; 
							Data<String, Number> first = null;
							Data<String, Number> second = null; 
							double newelement=0;
							
							for(int i = gap; i < bars.size() ; i++ )
							{
								
								newelement = getval(bars.get(i));
								
								 j = i;
								
								
								while( (j >= gap) && (getval(bars.get(j-gap)) > newelement) )
								{
								
									first = bars.get(j);
									second = bars.get(j-gap);
									
									prestyleset(first, second);
									
									visualizeswap(first,second);

									
									poststyleset_forshellsort(bars,first,second,gap, 1);
									j-=gap;
									
								}	
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
