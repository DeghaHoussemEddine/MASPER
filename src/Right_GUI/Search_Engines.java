package Right_GUI;

import Left_gui.SwitchButton2;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Search_Engines  extends TitledPane{

	private SwitchButton2  ACMDL;
	private SwitchButton2  Google_Scholar;
	private SwitchButton2  Microsoft_Academic;
	private SwitchButton2  PubMed ;
	private SwitchButton2  Refseek;
	private SwitchButton2  CiteSeerX;
	private SwitchButton2  Semantic_Scholar ;
	private SwitchButton2  EuropePMC;
	private SwitchButton2  Science;
	
	public Search_Engines() {
		// TODO Auto-generated constructor stub
		
		double x = 250;
		double y = 615;
		// TODO Auto-generated constructor stub
		Pane usersPane = new Pane();
		usersPane.setPadding(new Insets(2, 2, 2, 2));
		this.setText("Search Engines");
		this.setContent(usersPane);
		this.setPadding(new Insets(2, 2, 2, 2));
	
		usersPane.setPrefSize(x, y);
		VBox v = new VBox();
		v.setSpacing(10);
		
		GridPane gridPane = new GridPane();
		gridPane.setPrefWidth(250);
		gridPane.setHgap(12);
		gridPane.setVgap(12);

	//----------------------------------------------------------------------------------------------	
		Text Google_Scholart = new Text("Google Scholar");
		Google_Scholart.setId("textwhite2");
				
		Google_Scholar = new SwitchButton2();
		Google_Scholar.setDisable(true);
		gridPane.add(Google_Scholart, 0, 0);
		gridPane.add(Google_Scholar, 1, 0);
		//----------------------------------------------------------------------------------------------	
			Text Microsoft_Academict = new Text("Microsoft Academict");
			Microsoft_Academict.setId("textwhite2");
			Microsoft_Academic = new SwitchButton2();
			Microsoft_Academic.setDisable(true);
				gridPane.add(Microsoft_Academict, 0, 1);
				gridPane.add(Microsoft_Academic, 1, 1);
				//----------------------------------------------------------------------------------------------	
				Text PubMedt = new Text("PubMed");
				PubMedt.setId("textwhite2");
				PubMed = new SwitchButton2();
				PubMed.setDisable(true);
				gridPane.add(PubMedt, 0, 2);
				gridPane.add(PubMed, 1, 2);
			
				//----------------------------------------------------------------------------------------------	
				Text Refseekt = new Text("Refseek");
				Refseekt.setId("textwhite2");
				Refseek = new SwitchButton2();
				Refseek.setDisable(true);
				gridPane.add(Refseekt, 0, 3);
				gridPane.add(Refseek, 1, 3);
				//----------------------------------------------------------------------------------------------	
				Text CiteSeerXt = new Text("CiteSeerX");
				CiteSeerXt.setId("textwhite2");
				CiteSeerX = new SwitchButton2();
				CiteSeerX.setDisable(true);
				gridPane.add(CiteSeerXt, 0, 4);
				gridPane.add(CiteSeerX, 1,4);
				
				
				//----------------------------------------------------------------------------------------------	
				Text Semantic_Scholart = new Text("Semantic Scholar");
				Semantic_Scholart.setId("textwhite2");
				Semantic_Scholar = new SwitchButton2();
				Semantic_Scholar.setDisable(true);
				gridPane.add(Semantic_Scholart, 0, 5);
				gridPane.add(Semantic_Scholar, 1,5);
				//----------------------------------------------------------------------------------------------	
				Text EuropePMCt = new Text("EuropePMC");
				EuropePMCt.setId("textwhite2");
				EuropePMC = new SwitchButton2();
				EuropePMC.setDisable(true);
				gridPane.add(EuropePMCt, 0, 6);
				gridPane.add(EuropePMC, 1,6);
				//----------------------------------------------------------------------------------------------	
				Text Sciencet = new Text("Science");
				Sciencet.setId("textwhite2");
				Science = new SwitchButton2();
				Science.setDisable(true);
			
				gridPane.add(Sciencet, 0, 7);
				gridPane.add(Science, 1,7);
			
				//----------------------------------------------------------------------------------------------	
				Text ACMDLt = new Text("ACM Degital Library");
				ACMDLt.setId("textwhite2");
				ACMDL = new SwitchButton2();
				ACMDL.SetValue(true);
				gridPane.add(ACMDLt, 0, 8);
				gridPane.add(ACMDL, 1,8);
		
		gridPane.setAlignment(Pos.TOP_CENTER);
		this.setVisible(true);
	
		v.getChildren().add(gridPane);
		v.setPadding(new Insets(10, 5, 5, 5));
		v.setAlignment(Pos.TOP_CENTER);
		usersPane.setId("background");	
      	usersPane.getChildren().add(v);
	}
}
