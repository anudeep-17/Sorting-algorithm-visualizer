package application;

import java.util.Arrays;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;

public class countingsort extends animation
{

	
	
	public countingsort()
	{
		//empty constructor.
	}
	
	
	
	/*
     * --------------------- counting Sort algorithm ----------------------------- 
     */
	/**
     * counting Sort algorithm
	 * @throws InterruptedException 
     */
	
	protected Task<Void> countingsortTask(ObservableList<Data<String, Number>> bars)
	{   
		return new Task<Void>()
				{

					@Override
					protected Void call() throws Exception 
					{
						// TODO Auto-generated method stub
						
						
						countingsorter(bars, 0, 101);
						
						return null;
					}

				};
	}
	
	
	
	private void countingsorter(ObservableList<Data<String, Number>> bars, int min, int max) throws Exception 
	{
		
		int[] count = new int[102];
		
		for(int i = 0; i < bars.size(); i++)
		{
			count[getval(bars.get(i))]++;
		}
	
		
		for(int element: count)  
		{  
			System.out.print(" " + element);  
		}  
		
		
		
		int index = 0 ;
		int colorsetter = 1;
		
		 for(int i = 0 ; i <= max ; i++)
		{
			
			while(count[i] > 0)
			{
				Data<String,Number> first = null;
				Data<String, Number> second = null;
				for(int k = 0; k < bars.size(); k++)
				{
					if(getval(bars.get(k)) == i)
					{
						first = bars.get(index);
						second = bars.get(k);
						
						prestyleset(first,second);
						visualizeswap(bars.get(index), bars.get(k));
						poststyleset_forcountingsort(bars,first,second,colorsetter++);
						index++;
						count[i]--;
					}
					
				}
				

			}

		 }
		
	}
	
	

    private int getval(Data<String, Number> given)
    {
    	return given.getYValue().intValue();	
    }

    
}
