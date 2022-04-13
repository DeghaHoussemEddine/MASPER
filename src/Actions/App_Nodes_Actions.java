package Actions;

import java.util.ArrayList;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import ClassHelprs.DynamicTable;
import ClassHelprs.Liste;
import Crawler_Agents.ACM_Crawler_Agent;
import Crawler_Agents.Controled_ACM_Crawler_Agent;
import Nodes_Stectures.Article;
import application.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class App_Nodes_Actions implements EventHandler {
	Main App;
	int i = 0;
	
	private ArrayList<String[]> Data_input;
	private String[] Columns; 
	
	public App_Nodes_Actions(Main App) {
		this.App = App;
		
		Timeline animation = new Timeline();
	
	}

	public void handle(Event event) {
		
		if (event.getSource() == App.getMainpane().getHomePage().getSearchBtn()) {
			App.getMainpane().getHomePage().getProgressBar().setProgress(0.);
			Data_input = new ArrayList<String[]>();
			Columns = new String[9];
			Columns[0] = "iD";
			Columns[1] = "Type";
			Columns[2] = "Date";
			Columns[3] = "Title";
			Columns[4] = "Authors";
			Columns[5] = "Total Citations";
			Columns[6] = "Total Downloads";
			Columns[7] = "Link Access";
			Columns[8] = "Publiched in";

           				try { 
           					
								i = 0;
								Timeline animation = new Timeline();
								animation.getKeyFrames()
										.add(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
											public void handle(ActionEvent actionEvent) {

												App.getMainpane().getHomePage().getProgressBar().setProgress(i / 100.0);
												i=i+1;
											}
											
									
										}));
							//	animation.setAutoReverse(true);
								animation.setCycleCount(100);
								animation.setOnFinished(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										// TODO Auto-generated method stub
										App.getMainpane().getHomePage().getProgressBar().setProgress(1.0);
									}
									
								});
								animation.play();
								Controled_ACM_Crawler_Agent ACM_Crawler_Agent = new Controled_ACM_Crawler_Agent(App);
								ACM_Crawler_Agent.Crawling(App.getMainpane().getHomePage().getSearchBar().getText(),
										 animation, App);

								
								
								
							
							} catch (Exception e) {

							}

			
		}else {
			
		}
		
	/*	if (event.getSource() == App.getMainpane().getHomePage().getSearchBtn()) {
			App.getMainpane().getHomePage().getProgressBar().setProgress(0.);
			TimerTask task = new TimerTask() {
				public void run() {
					Platform.runLater(new Runnable() {
						public void run() {

							try {
								i = 0;
								Timeline animation = new Timeline();
								animation.getKeyFrames()
										.add(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
											public void handle(ActionEvent actionEvent) {

												App.getMainpane().getHomePage().getProgressBar().setProgress(i / 1000.0);
												i=i+1;
											}
											
									
										}));
							//	animation.setAutoReverse(true);
								animation.setCycleCount(1000);
								animation.setOnFinished(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										// TODO Auto-generated method stub
										App.getMainpane().getHomePage().getProgressBar().setProgress(1.0);
									}
									
								});
								animation.play();
								ACM_Crawler_Agent ACM_Crawler_Agent = new ACM_Crawler_Agent(
										App.getMainpane().getHomePage().getHomePage());
								ACM_Crawler_Agent.Crawling(App.getMainpane().getHomePage().getSearchBar().getText(),
										 animation);

								
							} catch (Exception e) {

							}

						}
					});

				}
			};

			try {
				new Thread(task).start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}*/
	}

	public ArrayList<String[]> getData_input() {
		return Data_input;
	}

	public void setData_input(ArrayList<String[]> data_input) {
		Data_input = data_input;
	}

}
