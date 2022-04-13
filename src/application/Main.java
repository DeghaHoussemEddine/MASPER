package application;

import java.io.File;

import Actions.App_Nodes_Actions;
import Center_Gui.Mainpane;
import ClassHelprs.file;
import Left_gui.UserLefPane;
import Left_gui.leftpane;
import Right_GUI.rightpane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.PrinterJob;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	private Mainpane Mainpane;
	private App_Nodes_Actions Menu_Actions;
	private rightpane rightpane;
	leftpane leftpane ;
	public App_Nodes_Actions getMenu_Actions() {
		return Menu_Actions;
	}

	public void setMenu_Actions(App_Nodes_Actions menu_Actions) {
		Menu_Actions = menu_Actions;
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			file f = new file();
			String[] words = f.Read_from_file("files//words");

			BorderPane root = new BorderPane();

			UserLefPane UserLefPane = new UserLefPane(words, 280, 100);
			 leftpane = new leftpane(words, 350, 600);
			VBox vleft = new VBox();
			vleft.getChildren().addAll(UserLefPane, leftpane);
			
			vleft.setMaxWidth(350);
			Mainpane = new Mainpane();
			
			 rightpane = new rightpane();
			
			root.setLeft(vleft);
			root.setCenter(Mainpane);
			root.setRight(rightpane);

			Scene scene = new Scene(root, 1200, 650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("MASPER V 1.0.0 - 2021 © Copyrights Dr. Degha Houssem Eddine ™  ");
			primaryStage.getIcons().add(new Image(new File("icons//logo.png").toURI().toString()));
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setMaxHeight(650);
			primaryStage.setMaxWidth(1400);
		//	Login Login = new Login(primaryStage);
			int TimerInt = 100;
			primaryStage.show();

		/*	Login.getBtnLogin().setOnAction(action -> {

				Login.getLblMessage().setText("");
				if (Login.getTxtUserName().getText().equals("") && Login.getPf().getText().equals("")) {
					Login.ProgressBar.setProgress(0.);
					Timeline animation = new Timeline();

					animation.getKeyFrames().add(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
						public void handle(ActionEvent actionEvent) {
							Login.ProgressBar.setProgress(Login.ProgressBar.getProgress() + 0.02);
							if (Login.ProgressBar.getProgress() >= 1) {
								primaryStage.show();
								Login.getStage().hide();
							}
						}
					}));
					animation.setCycleCount(100);
					animation.play();
					new file().creat_file("Logfile.txt");
				} else {
					Login.getLblMessage().setText("Wrong username or password!");
				}
			});
*/
			Menu_Actions = new App_Nodes_Actions(this);
			Mainpane.getHomePage().getSearchBtn().setOnAction(Menu_Actions);
			Mainpane.getHomePage().getStopSearchBtn().setOnAction(Menu_Actions);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public rightpane getRightpane() {
		return rightpane;
	}

	public void setRightpane(rightpane rightpane) {
		this.rightpane = rightpane;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Mainpane getMainpane() {
		return Mainpane;
	}

}
