package application;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart.Data;

public class bubblesort 
{
	
	
	
	bubblesort(ObservableList<Data<String, Number>> bars)
	{
		bubbleSort(bars);
	}
	
	
	
	
	
	/*
     * ---------------------Bubble Sort algorithm----------------------------- 
     */
    
    private void bubbleSort(ObservableList<Data<String, Number>> bars) 
    {
        double[] array = bars.stream().mapToDouble(data -> data.getYValue().doubleValue()).toArray();

        double temp;
        for(int i = 0; i <array.length; i++)
        {
            for(int j = 1; j <array.length -i; j++)
            {
                if(array[j-1] > array[j])
                {
                    temp = array[j -1];
                    array[j-1] = array[j];
                    array[j] = temp;
                   
                }
            }
        }
        
        
        for (int i = 0; i < array.length; i++) 
        {
        	  	
            bars.get(i).setYValue(array[i]);
          
        }
    }

}
