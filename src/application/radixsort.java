package application;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;

public class radixsort extends animation
{

	public radixsort()
	{
		
	}
	
	/*
     * --------------------- radix Sort algorithm ----------------------------- 
     */
	/**
     * radix Sort algorithm
	 * @throws InterruptedException 
     */
	
	protected Task<Void> radixsortTask(ObservableList<Data<String, Number>> bars)
	{   
		return new Task<Void>()
				{

					@Override
					protected Void call() throws Exception 
					{
						// TODO Auto-generated method stub
						
						
						radixsorter(bars, 10, 3);
						
						return null;
					}

					private void radixsorter(ObservableList<Data<String, Number>> bars, int radix, int width) throws Exception 
					{
						// TODO Auto-generated method stub
						for(int i = 0; i<width; i++)
						{
							radixsinglesort(bars, i , radix);
						}
						setallsamecolor(bars);
					}

					private void radixsinglesort(ObservableList<Data<String, Number>> bars, int position, int radix) throws Exception
					{
						// TODO Auto-generated method stub
						int numItems = bars.size();
						int count[] = new int[radix];
						for(int i = 0; i < bars.size(); i++)
						{
							count[getDigit(position,getval(bars.get(i)),radix)]++;
						}
						
						for(int i = 1; i < radix; i++)
						{
							count[i]+=count[i-1];
						}
						
						int [] temp = new int[numItems];
						
						for(int k = numItems-1 ; k>0; k--)
						{
							temp[--count[getDigit(position, getval(bars.get(k)), radix)]] = getval(bars.get(k));
						} 
						
						for(int l = 0; l < numItems; l++)
						{
							for(int m = 0; m < bars.size(); m++)
							{
								
								if(getval(bars.get(m)) == temp[l])
								{
									prestyleset(bars.get(m), bars.get(l));
									visualizeswap(bars.get(m),bars.get(l));
									poststyleset_forradixsort(bars.get(l), bars.get(m));
									
								}
								
							}
							
						}
						
					}

					private int getDigit(int position, int getval, int radix)
					{
						// TODO Auto-generated method stub
						return getval/(int)Math.pow(radix,position)%radix;
					}

				};
	}
	
	 private int getval(Data<String, Number> given)
	    {
	    	return given.getYValue().intValue();
	    }
	
}


