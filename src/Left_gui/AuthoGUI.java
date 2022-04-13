package Left_gui;

import java.io.File;
import java.util.Date;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;

import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AuthoGUI extends VBox {

	public AuthoGUI(String img, String info[], String date) {
		super();
		File f8 = new File(img);
		Image i8 = new Image(f8.toURI().toString());
		final ImageView selectedImage8 = new ImageView();
		Button users_online = new Button("");
		users_online.setTooltip(new Tooltip("Degha Houssem Eddine"));
		users_online.setId("button");
		users_online.setContentDisplay(ContentDisplay.CENTER);
		selectedImage8.setImage(i8);
		selectedImage8.setFitHeight(55);
		selectedImage8.setFitWidth(50);

		users_online.setGraphic(selectedImage8);

		GridPane layout = new GridPane();
		layout.setHgap(5);
		layout.setVgap(5);

		layout.add(users_online, 0, 0);

		layout.add(new Text(info[0]), 1, 0);
		layout.add(new Text(info[1]), 1, 1);
		layout.add(new Text(info[2]), 1, 2);
		// layout.setAlignment(Pos.TOP_LEFT);

		layout.setColumnSpan(users_online, 1);
		layout.setRowSpan(users_online, 4);

		Text label = new Text(date);

		label.setId("textwhite2");

		layout.setPadding(new Insets(6, 1, 6, 1));
		layout.setGridLinesVisible(false);
		layout.setHgap(3);

		VBox v = new VBox();
		v.getChildren().add(label);
		v.setVgrow(label, Priority.ALWAYS);
		v.setAlignment(Pos.BOTTOM_CENTER);
		// v.setStyle("-fx-padding: 8 0 0 10");
		layout.add(v, 0, 6, 4, 1);

		this.setId("toolbarContainer");
		this.setSpacing(3);

		this.setAlignment(Pos.CENTER);
		this.getChildren().add(layout);
		this.getStyleClass().add("toolbarContainer");
		ScaleTransition scaleTransition;

		scaleTransition = new ScaleTransition();
		scaleTransition.setNode(this);
		scaleTransition.setDuration(Duration.seconds(1));
		scaleTransition.setFromX(0.5);
		scaleTransition.setFromY(0.5);
		scaleTransition.setToX(1);
		scaleTransition.setToY(1);
		scaleTransition.setCycleCount(1);
		scaleTransition.setAutoReverse(true);

		scaleTransition.play();

	}

}
