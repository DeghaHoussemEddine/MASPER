package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login {

	private TextField txtUserName;
	private PasswordField pf;
	private Text lblMessage;
	private String username = new String();
	private String passoword = new String();
	private Stage stage;

	private double initX = 0;
	private double initY = 0;
	private Button btnLogin;
	private Button exit;
	
	double w =1000;
	double h = 700;
	public ProgressBar   ProgressBar;

	
	Login(final Stage win) {

	

		stage = new Stage(  StageStyle.UNDECORATED);
		stage.setTitle("V 1.0.0  MASPER  2021 © Copyrights Dr. Degha houssem Eddine ™");
		stage.setResizable(false);
		BorderPane MainPane = new BorderPane();
		// ------------- Bottom Pane -----------------------------
		GridPane BottomPane = new GridPane();
		BottomPane.setPadding(new Insets(5,5,5,5));
		BottomPane.setHgap(5);
		BottomPane.setVgap(5);
		// BottomPane.setPrefHeight(h / 2 / 7);
		BottomPane.setMaxHeight(10);
		BottomPane.setId("bottompane");
		File f2 = new File("icons//logo.png");
		final Image i2 = new Image(f2.toURI().toString());
	
		BottomPane.add(new Text("V 1.0.0  MASPER  2021 © \n Copyrights Dr. Degha houssem Eddine ™"), 1, 0);

		Separator Separator1 = new Separator();
		Separator1.setOrientation(Orientation.VERTICAL);
		BottomPane.add(Separator1, 2, 0);// BottomPane.setRowSpan(Separator1,
											// 3);
		File f3 = new File("icons//dzsoftn.png");
		final Image i3 = new Image(f3.toURI().toString());
		final ImageView dzsoft_png = new ImageView();
		BottomPane.add(
				new Text("Email: degha.houssem@outlook.com \n Phone: +(213)697381211"),
				3, 0);
		BottomPane.setAlignment(Pos.CENTER);
		// --------------------------------------------------------------------------------------------------------------------
		HBox Tophbox = new HBox();
		Tophbox.setSpacing(10);Tophbox.setAlignment(Pos.CENTER);

		
		Text TopText = new Text("LogIn");
		TopText.setId("logo");
		Tophbox.getChildren().addAll(TopText);
		MainPane.setTop(Tophbox);
		// -------------------------------------------------------------------------------------------------------------------
		Text lblUserName = new Text("Username" + " : ");
		txtUserName = new TextField();
		txtUserName.setPrefWidth(w / 5);
		Text lblPassword = new Text("Password" + " : ");
		pf = new PasswordField();
		pf.setPrefWidth(w / 5);
		btnLogin = new Button("Login");
		btnLogin.setPrefWidth(w / 5 / 3);
		exit = new Button("Exit" + " ");
		exit.setPrefWidth(w / 5 / 3);
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {

				System.exit(0);

			}
		});

		lblMessage = new Text();
		lblMessage.setId("errer");
		lblUserName.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
		lblPassword.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
		lblUserName.setId("text");
		lblPassword.setId("text");

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(0, 0, 15, 0));
		gridPane.setHgap(25);
		gridPane.setVgap(15);

		gridPane.add(lblUserName, 0, 2);
		gridPane.add(txtUserName, 1, 2);
		gridPane.add(lblPassword, 0, 3);
		gridPane.add(pf, 1, 3); // gridPane.setAlignment(Pos.TOP_RIGHT);
		HBox ButtonsHbox = new HBox();
		ButtonsHbox.setSpacing(25);
		ButtonsHbox.getChildren().addAll(exit, btnLogin);
		ButtonsHbox.setAlignment(Pos.CENTER);
		gridPane.add(ButtonsHbox, 0, 6);
		gridPane.setColumnSpan(ButtonsHbox, 4);

		// gridPane.setColumnSpan(btnLogin, 3);
		// gridPane.setRowSpan(btnLogin, 4); lblMessage.setId("e");
		gridPane.add(lblMessage, 1, 4);

		btnLogin.setId("btnLogin");
		exit.setId("exit");
		gridPane.setHalignment(exit, HPos.RIGHT);

		gridPane.setHalignment(lblUserName, HPos.RIGHT);
		gridPane.setHalignment(lblPassword, HPos.RIGHT);

		gridPane.setAlignment(Pos.CENTER);
		btnLogin.setPrefSize(120, 25);
		exit.setPrefSize(120, 25);
		MainPane.setCenter(gridPane);
		MainPane.setAlignment(gridPane, Pos.CENTER);
		/// -----------------------------------------------------------------------------------------
		MainPane.setAlignment(TopText, Pos.CENTER);
		MainPane.setPadding(new Insets(10, 0, 0, 0));
		MainPane.setId("MainPane");
	
		VBox VboxButtom = new VBox();
		   ProgressBar = new 	ProgressBar();
		   ProgressBar.setPrefSize( w / 3 + 245,10);
		   ProgressBar.setMinHeight(5);
		   ProgressBar.setId("progress");
		
		   VboxButtom.getChildren().addAll(BottomPane,ProgressBar);
		MainPane.setBottom(VboxButtom);
		
		Scene scene = new Scene(MainPane, w / 3 + 250, h / 2 + 100);
		
		scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
		stage.setScene(scene);
		stage.getIcons().add(new Image(new File("icons//logo.png").toURI().toString()));
		scene.setFill(new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.REPEAT, new Stop[] {

				new Stop(0, Color.WHITE),

				new Stop(1, Color.GRAY)

		}));
		stage.centerOnScreen();
		stage.show();

		// when mouse button is pressed, save the initial position of screen

		MainPane.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent me) {

				initX = me.getScreenX() - stage.getX();

				initY = me.getScreenY() - stage.getY();

			}

		});

		MainPane.setOnMouseDragged(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent me) {

				stage.setX(me.getScreenX() - initX);

				stage.setY(me.getScreenY() - initY);

			}

		});

		

	}

	public TextField getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(TextField txtUserName) {
		this.txtUserName = txtUserName;
	}

	public PasswordField getPf() {
		return pf;
	}

	public void setPf(PasswordField pf) {
		this.pf = pf;
	}

	public Text getLblMessage() {
		return lblMessage;
	}

	public void setLblMessage(Text lblMessage) {
		this.lblMessage = lblMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassoword() {
		return passoword;
	}

	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}

	

	public Button getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(Button btnLogin) {
		this.btnLogin = btnLogin;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	
	public double getInitX() {
		return initX;
	}

	public void setInitX(double initX) {
		this.initX = initX;
	}

	public double getInitY() {
		return initY;
	}

	public void setInitY(double initY) {
		this.initY = initY;
	}
}
