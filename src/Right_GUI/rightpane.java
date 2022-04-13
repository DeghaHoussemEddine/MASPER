package Right_GUI;

import java.util.Random;

import eu.hansolo.medusa.Clock;
import eu.hansolo.medusa.Clock.ClockSkinType;
import eu.hansolo.medusa.ClockBuilder;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.Gauge.SkinType;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.skins.BarChartItem;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class rightpane extends VBox {
	boolean Tab_Vis = true;
	boolean Tab_Vis2 = true;
	// --------------------------------------------------------------------------------
	private TitledPane Properties_Accordion;
	private Properties_Seting Properties_Engine;
	private Academic_Publishers Academic_Publishers;
	private Search_Engines Search_Engines;

	double x = 250;
	double y = 615;
	private double StartDateVal;
	private double StopDataVal;

	private Gauge gauge27;
	AnimationTimer timer;
	long lastTimerCall = 0;
	Random RND = new Random();

	Clock clock11;
	private TextField PageField;
	private TextField ArticlesMountField;
	private Text startDate;
	private Text stopDate;

	Slider StartDate;
	Slider StopDate;
	ChoiceBox SelectByJournals;
	ChoiceBox SelectByAuthors;

	public ChoiceBox getSelectByJournals() {
		return SelectByJournals;
	}

	public ChoiceBox getSelectByAuthors() {
		return SelectByAuthors;
	}

	public rightpane() {
		super();

		usersTitledPane();

		final Accordion accordion = new Accordion();
		accordion.setCache(true);

		accordion.getPanes().add(Properties_Accordion);
		Properties_Accordion.setCache(true);

		Properties_Engine = new Properties_Seting();
		Properties_Engine.setCache(true);
		accordion.getPanes().add(Properties_Engine);

		Academic_Publishers = new Academic_Publishers();
		accordion.getPanes().add(Academic_Publishers);

		Search_Engines = new Search_Engines();
		accordion.getPanes().add(Search_Engines);

		Properties_Accordion.setOnMousePressed(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				if (Tab_Vis == true) {
					Properties_Engine.setVisible(false);
					Academic_Publishers.setVisible(false);
					accordion.getPanes().remove(Properties_Engine);

					accordion.getPanes().remove(Academic_Publishers);

					accordion.getPanes().remove(Search_Engines);

					Tab_Vis = false;
					// TODO Auto-generated method stub
				} else {
					Tab_Vis = true;
					Properties_Engine.setVisible(true);
					Academic_Publishers.setVisible(true);
					accordion.getPanes().add(Properties_Engine);
					accordion.getPanes().add(Academic_Publishers);
					accordion.getPanes().add(Search_Engines);
				}
			}
		});

	/*	Properties_Engine.setOnMousePressed(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				if (Tab_Vis2 == true) {
					Academic_Publishers.setVisible(false);
					accordion.getPanes().remove(Academic_Publishers);
					Tab_Vis2 = false;
					// TODO Auto-generated method stub
				} else {
					Tab_Vis2 = true;
					Academic_Publishers.setVisible(true);
					accordion.getPanes().add(Academic_Publishers);
				}
			}
		});
*/
		this.getChildren().add(accordion);

		this.setId("background");
	}

	public TitledPane usersTitledPane() {

		Pane usersPane = new Pane();
		usersPane.setPadding(new Insets(2, 2, 2, 2));
		Properties_Accordion = new TitledPane("Home Pane", usersPane);
		Properties_Accordion.setPadding(new Insets(2, 2, 2, 2));

		usersPane.setPrefSize(x, y);

		VBox v = new VBox();
		v.setSpacing(10);

		Text TextEngine = new Text("Start/Stop MASPER Engine : ");

		Text page = new Text("Pages Number : ");
		page.setId("textwhite2");
		PageField = new TextField();
		PageField.setPrefSize(100, 25);
		Text AcriclesByPage = new Text("Articles per page :");
		AcriclesByPage.setId("textwhite2");
		ArticlesMountField = new TextField();
		ArticlesMountField.setPrefSize(100, 25);

		GridPane gridPane = new GridPane();
		gridPane.setPrefWidth(250);
		gridPane.setHgap(12);
		gridPane.setVgap(8);

		gridPane.add(page, 0, 0);
		gridPane.add(PageField, 1, 0);

		gridPane.add(AcriclesByPage, 0, 1);
		gridPane.add(ArticlesMountField, 1, 1);

		Separator s = new Separator(Orientation.HORIZONTAL);

		gridPane.add(s, 0, 2);
		gridPane.setColumnSpan(s, 2);

		startDate = new Text("Start Date: 2000");
		startDate.setId("textwhite2");

		gridPane.add(startDate, 0, 3);

		StartDate = new Slider(0.0, 1.0, 0.5);
		StartDate.setPrefWidth(100);
		StartDate.setId("slider");
		// StartDate.setValue(StartDateVal);
		StartDate.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue o, Object oldVal, Object newVal) {
				StartDateVal = (Double) newVal;
				int x = (int) StartDateVal;
				// System.out.println("StartDateVal = "+StartDateVal);
				startDate.setText("Start Date:  " + x);
			}

		});
		StartDate.setPadding(new Insets(7));
		StartDate.setMin(2000);
		StartDate.setMax(2021);
		StartDate.setValue(2010);

		StartDate.setShowTickMarks(true);
		StartDate.setMajorTickUnit(10);
		StartDate.setMinorTickCount(10);
		StartDate.setBlockIncrement(10);

		stopDate = new Text("Stop Date: 2021");
		stopDate.setId("textwhite2");
		Slider StopDate = new Slider(0.0, 1.0, 0.5);
		StopDate.setPrefWidth(100);
		StopDate.setId("slider");
		// StopDate.setValue(StopDataVal);
		StopDate.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue o, Object oldVal, Object newVal) {
				StopDataVal = (Double) newVal;
				int x = (int) StopDataVal;
				stopDate.setText("Start Date:  " + x);
				// System.out.println("StopDataVal = "+StopDataVal);
			}

		});

		StopDate.setPadding(new Insets(7));
		StopDate.setMin(2000);
		StopDate.setMax(2021);
		StopDate.setValue(2010);

		StopDate.setShowTickMarks(true);
		StopDate.setMajorTickUnit(10);
		StopDate.setMinorTickCount(10);
		StopDate.setBlockIncrement(10);

		gridPane.add(StartDate, 0, 4);

		gridPane.add(stopDate, 0, 5);

		gridPane.add(StopDate, 0, 6);
		gridPane.setColumnSpan(StartDate, 2);
		gridPane.setColumnSpan(StopDate, 2);

		Text JournalText = new Text("Filter By Journal: ");
		JournalText.setId("textwhite2");
		SelectByJournals = new ChoiceBox();
		SelectByJournals.getItems().addAll("ACM Transactions on Computing Education");
		SelectByJournals.getSelectionModel().selectFirst();
		SelectByJournals.setPrefWidth(200);

		Text AuthorsText = new Text("Filter By Author: ");
		AuthorsText.setId("textwhite2");
		SelectByAuthors = new ChoiceBox();
		SelectByAuthors.getItems().addAll("Mark J. Guzdial");
		SelectByAuthors.getSelectionModel().selectFirst();
		SelectByAuthors.setPrefWidth(200);

		gridPane.add(JournalText, 0, 7);
		gridPane.add(SelectByJournals, 0, 8);
		gridPane.setColumnSpan(SelectByJournals, 2);
		gridPane.add(AuthorsText, 0, 9);
		gridPane.add(SelectByAuthors, 0, 10);
		gridPane.setColumnSpan(SelectByAuthors, 2);

		gauge27 = GaugeBuilder.create().skinType(SkinType.TILE_SPARK_LINE).title("Downlowind Speed").alertMessage("Max")
				.animated(true).areasVisible(true).areaTextVisible(true).barEffectEnabled(true)

				.minValue(0).maxValue(1000).padding(new Insets(0)).prefSize(200, 200).averageVisible(true).build();
		// gauge27.setPrefSize(200, 120);
		// gauge27.setMaxHeight(120);
		// gauge27.setMinWidth(200);
		// gridPane.setColumnSpan(gauge27, 2);
		lastTimerCall = System.nanoTime();
		/*
		 * timer = new AnimationTimer() {
		 * 
		 * @Override public void handle(long now) { if (now > lastTimerCall +
		 * 0_500_000_000l) {
		 * 
		 * gauge27.setValue(RND.nextDouble() * gauge27.getRange() +
		 * gauge27.getMinValue() + 3);
		 * 
		 * lastTimerCall = now; } } }; timer.start();
		 */
		gridPane.setAlignment(Pos.TOP_CENTER);

		clock11 = ClockBuilder.create().skinType(ClockSkinType.DIGITAL).running(true).prefSize(150, 50)
				.textColor(Color.WHITE).dateColor(Color.LIGHTGRAY).build();

		gridPane.add(gauge27, 0, 11);
		Separator s2 = new Separator(Orientation.HORIZONTAL);
		gridPane.setColumnSpan(gauge27, 2);
		gridPane.add(s2, 0, 12);
		gridPane.setColumnSpan(s2, 2);

		v.getChildren().add(gridPane);

		v.setPadding(new Insets(5, 5, 5, 5));
		v.setAlignment(Pos.TOP_CENTER);
		usersPane.setId("background");

		v.getChildren().add(clock11);
		usersPane.getChildren().add(v);
		this.setAlignment(Pos.TOP_CENTER);
		return Properties_Accordion;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getStartDateVal() {
		return StartDateVal;
	}

	public void setStartDateVal(double startDateVal) {
		StartDateVal = startDateVal;
	}

	public double getStopDataVal() {
		return StopDataVal;
	}

	public void setStopDataVal(double stopDataVal) {
		StopDataVal = stopDataVal;
	}

	public boolean isTab_Vis() {
		return Tab_Vis;
	}

	public void setTab_Vis(boolean tab_Vis) {
		Tab_Vis = tab_Vis;
	}

	public Properties_Seting getProperties_Engine() {
		return Properties_Engine;
	}

	public void setProperties_Engine(Properties_Seting properties_Engine) {
		Properties_Engine = properties_Engine;
	}

	public void setStartDate(Slider startDate) {
		StartDate = startDate;
	}

	public void setStopDate(Slider stopDate) {
		StopDate = stopDate;
	}

	public void setSelectByJournals(ChoiceBox selectByJournals) {
		SelectByJournals = selectByJournals;
	}

	public void setSelectByAuthors(ChoiceBox selectByAuthors) {
		SelectByAuthors = selectByAuthors;
	}

	public Gauge getGauge27() {
		return gauge27;
	}

	public void setGauge27(Gauge gauge27) {
		this.gauge27 = gauge27;
	}

	public AnimationTimer getTimer() {
		return timer;
	}

	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}

	public long getLastTimerCall() {
		return lastTimerCall;
	}

	public void setLastTimerCall(long lastTimerCall) {
		this.lastTimerCall = lastTimerCall;
	}

	public Random getRND() {
		return RND;
	}

	public void setRND(Random rND) {
		RND = rND;
	}

	public Clock getClock11() {
		return clock11;
	}

	public void setClock11(Clock clock11) {
		this.clock11 = clock11;
	}

	public TextField getPageField() {
		return PageField;
	}

	public void setPageField(TextField pageField) {
		PageField = pageField;
	}

	public TextField getArticlesMountField() {
		return ArticlesMountField;
	}

	public void setArticlesMountField(TextField articlesMountField) {
		ArticlesMountField = articlesMountField;
	}

	public Text getStartDate() {
		return startDate;
	}

	public void setStartDate(Text startDate) {
		this.startDate = startDate;
	}

	public Text getStopDate() {
		return stopDate;
	}

	public void setStopDate(Text stopDate) {
		this.stopDate = stopDate;
	}

	public TitledPane getProperties_Accordion() {
		return Properties_Accordion;
	}

	public void setProperties_Accordion(TitledPane Properties_Accordion) {
		this.Properties_Accordion = Properties_Accordion;
	}

}
