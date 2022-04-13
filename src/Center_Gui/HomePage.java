package Center_Gui;

import java.io.File;
import java.util.ArrayList;
import java.util.TimerTask;
import javafx.application.Platform;
import ClassHelprs.DynamicTable;
import ClassHelprs.Liste;
import Crawler_Agents.ACM_Crawler_Agent;
import Nodes_Stectures.Article;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomePage extends Tab {
	public ProgressBar ProgressBar;
	private BorderPane HomePage;

	double width = 800;
	double height = 650;
	private TextField searchBar;

	private Button SearchBtn;
	private Button StopSearchBtn;

	public HomePage() {
		super("Search Pane");
		// TODO Auto-generated constructor stub
	}

	public void HomePagebuild() {

		HomePage = new BorderPane();
		Text tlogo = new Text("Search :");
		tlogo.setId("logo");

		ImageView logo_img = new ImageView(new Image(new File("icons//search.png").toURI().toString()));
		logo_img.setFitHeight(20);
		logo_img.setFitWidth(25);

		SearchBtn = new Button("Go");
		SearchBtn.setPrefSize(50, 25);
		
		

		StopSearchBtn = new Button("Stop");
		StopSearchBtn.setPrefSize(75, 25);
		
		
		searchBar = new TextField();
		searchBar.setPrefSize(350, 25);

		HBox h = new HBox();
		h.setSpacing(10);
		h.getChildren().addAll(tlogo, searchBar, SearchBtn,StopSearchBtn);
		h.setAlignment(Pos.CENTER);
		h.setPadding(new Insets(10));
		h.setId("panelogo");

		BorderPane main = new BorderPane();
		GridPane gridPane = new GridPane();
		gridPane.setHgap(20);
		gridPane.setVgap(15);

		main.setCenter(gridPane);

		main.setPadding(new Insets(40, (width * 4 / 6) / 9, 20, (width * 4 / 6) / 16));
		main.setId("panemain");
		HomePage.setTop(h);
		HomePage.setCenter(main);

		ProgressBar = new ProgressBar();
		ProgressBar.setPrefSize(905, 10);
		ProgressBar.setMinHeight(5);
		ProgressBar.setId("progress");
		ProgressBar.setProgress(1.0);
		HomePage.setBottom(ProgressBar);
		this.setContent(HomePage);
	}

	public Button getStopSearchBtn() {
		return StopSearchBtn;
	}

	public void setStopSearchBtn(Button stopSearchBtn) {
		StopSearchBtn = stopSearchBtn;
	}

	public ProgressBar getProgressBar() {
		return ProgressBar;
	}

	public void setProgressBar(ProgressBar progressBar) {
		ProgressBar = progressBar;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public BorderPane getHomePage() {
		return HomePage;
	}

	public void setHomePage(BorderPane homePage) {
		HomePage = homePage;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public Button getSearchBtn() {
		return SearchBtn;
	}

	public void setSearchBtn(Button searchBtn) {
		SearchBtn = searchBtn;
	}

	public TextField getSearchBar() {
		return searchBar;
	}

	public void setSearchBar(TextField searchBar) {
		this.searchBar = searchBar;
	}
}
