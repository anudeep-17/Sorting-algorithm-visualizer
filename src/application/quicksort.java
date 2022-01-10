package application;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;

public class quicksort extends animation
{
	
	public quicksort()
	{
		//empty constructor.
	}
	
	
	
	/*
     * --------------------- selection Sort algorithm ----------------------------- 
     */
	/**
     * selection Sort algorithm
	 * @throws InterruptedException 
     */
	protected Task<Void> quicksortTask(ObservableList<Data<String, Number>> bars)
	{   
		return new Task<Void>()
				{

					@Override
					protected Void call() throws Exception 
					{
						// TODO Auto-generated method stub
						
						quicksorter(bars, 0, bars.size());

						
						return null;
					}

					private void quicksorter(ObservableList<Data<String, Number>> bars, int start, int end) throws Exception 
					{
						// TODO Auto-generated method stub
						if(end-start<1)
						{
							return;
						}
						
						int pivotindex = partition(bars, start, end);
						
						quicksorter(bars,start, pivotindex);
						quicksorter(bars, pivotindex+1, end);
						
					}

					private int partition(ObservableList<Data<String, Number>> bars, int start, int end) throws Exception 
					{
						// TODO Auto-generated method stub
						double pivot = getval(bars.get(start));
						Data<String, Number> pivotelement = bars.get(start);
						
						int i = start;
						int j = end;
						
						while(i<j)
						{
							
							while(i<j && getval(bars.get(--j))>=pivot);
							prestyleset(bars.get(i), bars.get(j));
							if(i<j)
							{
								
								visualizeswap(bars.get(i),bars.get(j));
							}
							poststyleset(bars.get(i), bars.get(j));
							
							
							while(i<j && getval(bars.get(++i))<=pivot);
							prestyleset(bars.get(j), bars.get(i));
							if(i<j)
							{
								
								visualizeswap(bars.get(j),bars.get(i));
							}
							poststyleset(bars.get(j), bars.get(i));
						}
				
						return j;
					}
			
				};
	}
	

    private double getval(Data<String, Number> given)
    {
    	return given.getYValue().doubleValue();	
    }

    

}
