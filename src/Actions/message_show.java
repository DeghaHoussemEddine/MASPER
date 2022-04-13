package Actions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ClassHelprs.file;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class message_show {
	private static final String Manager = null;
	Stage stage;
	TextArea message;
	Button ok;
	ImageView img;

	public message_show() {
		file f = new file();
		String words[] = f.Read_from_file("files//words");

		stage = new Stage();
		BorderPane rootGroup = new BorderPane();

		double w = 1200;
		double h = 900;

		Pane CenterMain = new Pane();

		message = new TextArea("");
		message.setId("t");

		CenterMain.getChildren().add(message);
		CenterMain.setId("background");

		ok = new Button(words[47]);
		ok.setPrefWidth(150);
		ok.setPrefHeight(30);
		ok.setId("b");
		ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stage.hide();
			}
		});

		final Image i2 = new Image(new File("icons//no.png").toURI().toString());

		img = new ImageView();
		img.setImage(i2);
		img.setFitHeight(40);
		img.setFitWidth(40);
		img.setOpacity(0.95);

		rootGroup.setCenter(message);

		BorderPane BottomPane = new BorderPane();
		BottomPane.setPadding(new Insets(10));
		BottomPane.setId("ButtomPane");
		BottomPane.setRight(ok);
		BottomPane.setAlignment(ok, Pos.TOP_RIGHT);
		BottomPane.setId("background");
		BottomPane.setLeft(img);
		rootGroup.setBottom(BottomPane);
		message.setWrapText(true);
		message.setEditable(false);
		Scene scene = new Scene(rootGroup, w / 3, w / 9, Color.TRANSPARENT);
		scene.getStylesheets().add(getClass().getResource("message.css").toExternalForm());
		stage.setScene(scene);
		stage.getIcons().add(new Image(new File("icons//logo.png").toURI().toString()));
		stage.centerOnScreen();

	}

	public void show(String text, boolean type) {
		if (type == true) {
			final Image i2 = new Image(new File("icons//yes.png").toURI().toString());
			img.setImage(i2);
		} else {
			final Image i2 = new Image(new File("icons//no.png").toURI().toString());
			img.setImage(i2);
		}
		message.setText(text);
		stage.show();
	}
	

}
