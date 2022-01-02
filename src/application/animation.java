package application;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.transform.Translate;
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


	
}
