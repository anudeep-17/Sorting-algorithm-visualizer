package application;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart.Data;

public class mergesort extends animation
{
	
	public mergesort()
	{
		//empty constructor
		
	}
	
	protected Task<Void> mergesortTask(ObservableList<Data<String, Number>> bars)
	{   
		return new Task<Void>()
				{

					@Override
					protected Void call() throws Exception 
					{
						// TODO Auto-generated method stub
						
					mergesort(bars);
					
					//overall check after sorting it for visual confirmation.
					mergesort(bars);
 
						return null;
					}
					
					
					private void mergesort(ObservableList<Data<String, Number>> bars) throws Exception
					{
						 int mid= bars.size()/2;
							
						    Mergesortleft(bars, mid);
							Mergesortright(bars, bars.size()-mid);
							internalsort_with_colorscheme(bars,0, bars.size());
					}
					private void Mergesortleft(ObservableList<Data<String, Number>> bars, int size) throws Exception 
					{
						// TODO Auto-generated method stub
						

						if(size == 0)
						{
				           return;
						}
//						
						for(int i = 0; i < size; i++)
						{
						
							 for(int j = 0; j < (size-i)-2 ; j=j+2)
					    	   {

						          Data<String,Number> first = bars.get(j);
						          Data<String,Number> second = bars.get(j+1);
						          
						          prestyleset(first, second);
								 if(getval(bars.get(j)) > getval(bars.get(j+1)))
					    	   
										{
									 
											visualizeswap(bars.get(j), bars.get(j+1));
											
											
											
										}
								 
							   }
							 
					     }
						
						 internalsort(bars,0,size);
						 setleftsidecolor(bars, 0 , size);
							
							
							

							
					}
						
						
						
					


					private void Mergesortright(ObservableList<Data<String, Number>> bars, int size) throws Exception 
					{
						// TODO Auto-generated method stub
						
						if(size == 0)
						{
							return;
						}
				

						for(int i = 0; i < size; i++)
						{					
							for(int j = size; j < bars.size()-i-2; j=j+2)
					    	   {
								
								Data<String,Number> first = bars.get(j);
						        Data<String,Number> second = bars.get(j+1);
						          
						          prestyleset(first, second);
						          
								 if(getval(bars.get(j)) > getval(bars.get(j+1)))
					    	   
										{
											visualizeswap(bars.get(j), bars.get(j+1));
											
										}
							   }
					    }
						
						internalsort(bars,size, bars.size());
						setrightsidecolor(bars, size , bars.size());
							
						

						
					}
					
					

					
					
					private void internalsort(ObservableList<Data<String, Number>> bars, int start, int size) throws Exception 
					{
							// TODO Auto-generated method stub
						
						if(start==size)
						{
							return;
						}
						
						double minval = getval(bars.get(start));
						
						int minvalind = start ;
						
						for(int minvalindex = start; minvalindex < size; minvalindex++)
						{
							if(minval>getval(bars.get(minvalindex)))
							{
								minval = getval(bars.get(minvalindex));
								minvalind = minvalindex;
							}
						}
						
					
//						prestyleset(bars.get(start), bars.get(minvalind));
						
						visualizeswap(bars.get(start), bars.get(minvalind));
						
//						poststyleset_forinsertionsort(bars.get(start), bars.get(minvalind));
						
						
						internalsort(bars,start+1,size);
						
						
					}
					
					private void internalsort_with_colorscheme(ObservableList<Data<String, Number>> bars, int start, int size) throws Exception 
					{
							// TODO Auto-generated method stub
						
						if(start==size)
						{
							return;
						}
						
						double minval = getval(bars.get(start));
						
						int minvalind = start ;
						
						for(int minvalindex = start; minvalindex < size; minvalindex++)
						{
							if(minval>getval(bars.get(minvalindex)))
							{
								minval = getval(bars.get(minvalindex));
								minvalind = minvalindex;
							}
						}
						
					
//						prestyleset(bars.get(start), bars.get(minvalind));
						
						visualizeswap(bars.get(start), bars.get(minvalind));
						
						poststyleset_forinsertionsort(bars.get(start), bars.get(minvalind));
						
						
						internalsort_with_colorscheme(bars,start+1,size);
						
						
					}
				
				};
	}
	
	
	

	

	

	private double getval(Data<String, Number> given)
    {
    	return given.getYValue().doubleValue();
    }

	
	
	

}
