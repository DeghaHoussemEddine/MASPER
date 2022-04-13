package Right_GUI;

import eu.hansolo.medusa.ClockBuilder;
import eu.hansolo.medusa.GaugeBuilder;
import Left_gui.SwitchButton2;
import Left_gui.switchButton;
import eu.hansolo.medusa.Clock.ClockSkinType;
import eu.hansolo.medusa.Gauge.SkinType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
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

public class Properties_Seting extends TitledPane{
	private SwitchButton2 MASPERState;
	private SwitchButton2 FileSave ;
	private SwitchButton2 Download_Ref;
	private SwitchButton2 Download_Authors;
	
	private SwitchButton2 FilterByDate;
	private SwitchButton2 FilterByAuthors;
	private SwitchButton2 FilterByJournal;
	
	public Properties_Seting() {
		double x = 250;
		double y = 615;
		// TODO Auto-generated constructor stub
		Pane usersPane = new Pane();
		usersPane.setPadding(new Insets(2, 2, 2, 2));
		this.setText("Engine Settings");
		this.setContent(usersPane);
		this.setPadding(new Insets(2, 2, 2, 2));
	
		usersPane.setPrefSize(x, y);

		VBox v = new VBox();
		v.setSpacing(10);

	
		GridPane gridPane = new GridPane();
		gridPane.setPrefWidth(250);
		gridPane.setHgap(12);
		gridPane.setVgap(12);

		Text MASPERText = new Text("Allow MASPER Filtering");
		MASPERText.setId("textwhite2");
		 MASPERState = new SwitchButton2();
		 MASPERState.setDisable(true);
		gridPane.add(MASPERText, 0, 0);
		gridPane.add(MASPERState, 1, 0);
		
		Text FileText = new Text("Save Articles in File : ");
		FileText.setId("textwhite2");
		 FileSave = new SwitchButton2();
		// FileSave.setDisable(true);
		
		gridPane.add(FileText, 0, 1);
		gridPane.add(FileSave, 1, 1);

		Text RefText = new Text("Downloading References : ");
		RefText.setId("textwhite2");
		 Download_Ref = new SwitchButton2();
	//	 Download_Ref.setDisable(true);
		gridPane.add(RefText, 0, 2);
		gridPane.add(Download_Ref, 1, 2);
		

		Text AuthorsText = new Text("Downloading Full Author Data : ");
		AuthorsText.setId("textwhite2");
		 Download_Authors = new SwitchButton2();
	//	 Download_Authors.setDisable(true);
		
		gridPane.add(AuthorsText, 0, 3);
		gridPane.add(Download_Authors, 1, 3);
	
		
		Separator s2 = new Separator(Orientation.HORIZONTAL);
		gridPane.add(s2, 0, 4);
		gridPane.setColumnSpan(s2, 2);
		
		Text DateText = new Text("Allow Filter By Date : ");
		DateText.setId("textwhite2");
		FilterByDate = new SwitchButton2();
		FilterByDate.setDisable(true);
		
		gridPane.add(DateText, 0, 5);
		gridPane.add(FilterByDate, 1, 5);
		
		Text FilterByauthorText = new Text("Allow Filter By Author : ");
		FilterByauthorText.setId("textwhite2");
		FilterByAuthors = new SwitchButton2();
		FilterByAuthors.setDisable(true);
		
		gridPane.add(FilterByauthorText, 0, 6);
		gridPane.add(FilterByAuthors, 1, 6);
		
		Text FilterByJournalText = new Text("Allow Filter By Journal : ");
		FilterByJournalText.setId("textwhite2");
		FilterByJournal = new SwitchButton2();
		FilterByJournal.setDisable(true);
		
		gridPane.add(FilterByJournalText, 0, 7);
		gridPane.add(FilterByJournal, 1, 7);
		
		
		gridPane.setAlignment(Pos.TOP_CENTER);
		this.setVisible(true);
	
		v.getChildren().add(gridPane);
		v.setPadding(new Insets(10, 5, 5, 5));
		v.setAlignment(Pos.TOP_CENTER);
		usersPane.setId("background");	
      	usersPane.getChildren().add(v);
	
	}

	public SwitchButton2 getMASPERState() {
		return MASPERState;
	}

	public void setMASPERState(SwitchButton2 mASPERState) {
		MASPERState = mASPERState;
	}

	public SwitchButton2 getFileSave() {
		return FileSave;
	}

	public void setFileSave(SwitchButton2 fileSave) {
		FileSave = fileSave;
	}

	public SwitchButton2 getDownload_Ref() {
		return Download_Ref;
	}

	public void setDownload_Ref(SwitchButton2 download_Ref) {
		Download_Ref = download_Ref;
	}

	public SwitchButton2 getDownload_Authors() {
		return Download_Authors;
	}

	public void setDownload_Authors(SwitchButton2 download_Authors) {
		Download_Authors = download_Authors;
	}
	
}
