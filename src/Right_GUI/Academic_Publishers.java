package Right_GUI;
import Left_gui.SwitchButton2;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Academic_Publishers extends TitledPane{
	
	private SwitchButton2  ACM_Association_for_Computing_Machinery;
	private SwitchButton2  Cambridge_University_Press;
	private SwitchButton2  Elsevier;
	private SwitchButton2  IEEE ;
	private SwitchButton2  MDPI;
	private SwitchButton2  Nature;
	private SwitchButton2  Oxford_University_Press ;
	private SwitchButton2  Routledge;
	private SwitchButton2  Science;
	private SwitchButton2  SciELO;
	private SwitchButton2  Springer;
	private SwitchButton2  Taylor_Francis;
	private SwitchButton2  Wiley_Blackwell;
	private SwitchButton2  Others;
	
	public Academic_Publishers() {
		double x = 250;
		double y = 615;
		// TODO Auto-generated constructor stub
		Pane usersPane = new Pane();
		usersPane.setPadding(new Insets(2, 2, 2, 2));
		this.setText("Academic Publishers");
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
		Text ACM_Association_for_Computing_MachineryText = new Text("ACM");
		ACM_Association_for_Computing_MachineryText.setId("textwhite2");
		ACM_Association_for_Computing_Machinery = new SwitchButton2();
		ACM_Association_for_Computing_Machinery.SetValue(true);
		gridPane.add(ACM_Association_for_Computing_MachineryText, 0, 0);
		gridPane.add(ACM_Association_for_Computing_Machinery, 1, 0);
		//----------------------------------------------------------------------------------------------	
			Text Cambridge_University_PressText = new Text("Cambridge University Press");
				Cambridge_University_PressText.setId("textwhite2");
				Cambridge_University_Press = new SwitchButton2();
				Cambridge_University_Press.setDisable(true);
				gridPane.add(Cambridge_University_PressText, 0, 1);
				gridPane.add(Cambridge_University_Press, 1, 1);
				//----------------------------------------------------------------------------------------------	
				Text ElsevierText = new Text("Elsevier");
				ElsevierText.setId("textwhite2");
				Elsevier = new SwitchButton2();
				Elsevier.setDisable(true);
				gridPane.add(ElsevierText, 0, 2);
				gridPane.add(Elsevier, 1, 2);
			
				//----------------------------------------------------------------------------------------------	
				Text IEEEText = new Text("IEEE");
				IEEEText.setId("textwhite2");
				IEEE = new SwitchButton2();
				IEEE.setDisable(true);
				gridPane.add(IEEEText, 0, 3);
				gridPane.add(IEEE, 1, 3);
				//----------------------------------------------------------------------------------------------	
				Text MDPIText = new Text("MDPI");
				MDPIText.setId("textwhite2");
				MDPI = new SwitchButton2();
				MDPI.setDisable(true);
				gridPane.add(MDPIText, 0, 4);
				gridPane.add(MDPI, 1,4);
				
				
				//----------------------------------------------------------------------------------------------	
				Text NatureText = new Text("Nature");
				NatureText.setId("textwhite2");
				Nature = new SwitchButton2();
				Nature.setDisable(true);
				gridPane.add(NatureText, 0, 5);
				gridPane.add(Nature, 1,5);
				//----------------------------------------------------------------------------------------------	
				Text Oxford_University_PressText = new Text("Oxford University Press");
				Oxford_University_PressText.setId("textwhite2");
				Oxford_University_Press = new SwitchButton2();
				Oxford_University_Press.setDisable(true);
				gridPane.add(Oxford_University_PressText, 0, 6);
				gridPane.add(Oxford_University_Press, 1,6);
				//----------------------------------------------------------------------------------------------	
				Text RoutledgeText = new Text("Routledge");
				RoutledgeText.setId("textwhite2");
				Routledge = new SwitchButton2();
				Routledge.setDisable(true);
				gridPane.add(RoutledgeText, 0, 7);
				gridPane.add(Routledge, 1,7);
			
				
				//----------------------------------------------------------------------------------------------	
				Text ScienceText = new Text("Science");
				ScienceText.setId("textwhite2");
				Science = new SwitchButton2();
				Science.setDisable(true);
				gridPane.add(ScienceText, 0, 8);
				gridPane.add(Science, 1,8);
				//----------------------------------------------------------------------------------------------	
				Text SciELOText = new Text("Routledge");
				SciELOText.setId("textwhite2");
				Routledge = new SwitchButton2();
				Routledge.setDisable(true);
				gridPane.add(SciELOText, 0, 9);
				gridPane.add(Routledge, 1,9);
				//----------------------------------------------------------------------------------------------	
				Text Taylor_FrancisText = new Text("Taylor Francis");
				Taylor_FrancisText.setId("textwhite2");
				Taylor_Francis = new SwitchButton2();
				Taylor_Francis.setDisable(true);
				gridPane.add(Taylor_FrancisText, 0, 10);
				gridPane.add(Taylor_Francis, 1,10);
			
				//----------------------------------------------------------------------------------------------	
				Text Wiley_BlackwellText = new Text("Wiley Blackwell");
				Wiley_BlackwellText.setId("textwhite2");
				Wiley_Blackwell = new SwitchButton2();
				Wiley_Blackwell.setDisable(true);
				gridPane.add(Wiley_BlackwellText, 0, 11);
				gridPane.add(Wiley_Blackwell, 1,11);
			
				//----------------------------------------------------------------------------------------------	
				Text OthersText = new Text("Allow Others");
				OthersText.setId("textwhite2");
				Others = new SwitchButton2();
				Others.setDisable(true);
				gridPane.add(OthersText, 0, 12);
				gridPane.add(Others, 1,12);

		
		gridPane.setAlignment(Pos.TOP_CENTER);
		this.setVisible(true);
	
		v.getChildren().add(gridPane);
		v.setPadding(new Insets(10, 5, 5, 5));
		v.setAlignment(Pos.TOP_CENTER);
		usersPane.setId("background");	
      	usersPane.getChildren().add(v);
      	
		
	}

}
