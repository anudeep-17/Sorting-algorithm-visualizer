package application;

import java.util.concurrent.CountDownLatch;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart.Data;
import javafx.util.Duration;

public class animation<T>
{
	public <T> Animation swap(Data<?, T> first, Data<?,T>second)
	{
		
		
		double firstx = first.getNode().getParent().localToScene(first.getNode().getBoundsInParent()).getMinX();
		double secondx = second.getNode().getParent().localToScene(second.getNode().getBoundsInParent()).getMinX();
		double change = secondx-firstx;
		
		double fst =  first.getNode().getTranslateX();
		double sst = second.getNode().getTranslateX();
		
		TranslateTransition firstTransition = new TranslateTransition(Duration.millis(500), first.getNode());
		firstTransition.setByX(change);
		

		TranslateTransition secondTransition = new TranslateTransition(Duration.millis(500), second.getNode());
		secondTransition.setByX(-change);
		
		ParallelTransition translate = new ParallelTransition(firstTransition, secondTransition);
		
		
		translate.statusProperty().addListener((obs, oldStatus, newStatus) -> 
		{
			if(oldStatus==Animation.Status.RUNNING)
			{
				T temp = first.getYValue();
				first.setYValue(second.getYValue());
				second.setYValue(temp);
				first.getNode().setTranslateX(fst);
				second.getNode().setTranslateX(sst);
				
			}
		});
		return translate;
		
		
	}
	
	public void visualizeswap(Data<?,T> first, Data<?,T> second) throws Exception
	{
		CountDownLatch latch = new CountDownLatch(1);
		  

			Animation swap = swap(first, second);
			swap.setOnFinished(e -> latch.countDown());
			swap.play();
		   latch.await();
	}
	
	
	
	
	public void prestyleset(Data<?,T> first, Data<?,T> second) throws Exception
	{

			   first.getNode().setStyle("-fx-background-color: black ;");
			   second.getNode().setStyle("-fx-background-color: black ;");
			   Thread.sleep(50);
	}
	
	
	public void poststyleset(Data<?,T> first, Data<?,T> second) throws Exception
	{
		
		      Thread.sleep(50);
              first.getNode().setStyle(" ");
              second.getNode().setStyle("-fx-background-color: green;");
 
              
	}

	public void poststyleset_forinsertionsort( Data<?,T> first, Data<?,T> second) throws Exception
	{
		Thread.sleep(50);
        first.getNode().setStyle("-fx-background-color: green;");
        second.getNode().setStyle("-fx-background-color: green;");
	}
	
	public void poststyleset_forshellsort(ObservableList<Data<?,T>> bars, Data<?,T> first,Data<?,T> second, int index , int total) throws Exception
	{
		Thread.sleep(50);
        first.getNode().setStyle("-fx-background-color: green;");
        second.getNode().setStyle("-fx-background-color: green;");
        
        if(index == total)
        {
        	setallsamecolor(bars);
        }
	}
	
	public void setallsamecolor(ObservableList<Data<?,T>> bars)
	{
		for(int i = 0 ; i <bars.size(); i++)
		{
			bars.get(i).getNode().setStyle("-fx-background-color: green;");
		}
	}
	
	
	public void setleftsidecolor(ObservableList<Data<?,T>> bars, int start, int size) throws Exception
	{
		Thread.sleep(10);
		
		for(int i = start ; i <size; i++)
		{
			bars.get(i).getNode().setStyle("-fx-background-color: cyan;");
		}
	}
	

	public void setrightsidecolor(ObservableList<Data<?,T>> bars, int start, int size) throws Exception
	{
		Thread.sleep(10);
		
		for(int i = start ; i <size; i++)
		{
			bars.get(i).getNode().setStyle("-fx-background-color: blue;");
		}
	}
	
}
