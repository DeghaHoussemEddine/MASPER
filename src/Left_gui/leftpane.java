package Left_gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

public class leftpane extends VBox {
	private VBox Vbox_of_day;
	private switchButton on_off;

	public leftpane(String words[], double x, double y) {
		super();

		Vbox_of_day = new VBox();
		Vbox_of_day.setPrefSize(x, y);
		Vbox_of_day.setSpacing(10);
		Vbox_of_day.setPadding(new Insets(5, 5, 5, 5));
		Vbox_of_day.setId("backgroundwhiteborder");
		Vbox_of_day.setMaxWidth(x-50);
		ScrollPane s = new ScrollPane(Vbox_of_day);
		
		String[] AuthorsInfo = new String[3];
		AuthorsInfo[0] = "Mark J. Guzdial";
		AuthorsInfo[1] = "Citations: 4801";
		AuthorsInfo[2] = "Publications: 241";
		AuthoGUI AuthoGUI = new AuthoGUI("UsersPNG//Mark.png", AuthorsInfo, "University of Michigan, Ann Arbor" );
		AuthoGUI.setMaxWidth(x-100);
		Vbox_of_day.getChildren().add(AuthoGUI);
		//AuthoGUI.setDisable(true);
		
		String[] AuthorsInfo2 = new String[3];
		AuthorsInfo2[0] = "Jiawei Han";
		AuthorsInfo2[1] = "Citations: 29516";
		AuthorsInfo2[2] = "Publications: 617";
		AuthoGUI AuthoGUI2 = new AuthoGUI("UsersPNG//Han.png", AuthorsInfo2, "University of Illinois Urbana-Champaign" );
		AuthoGUI2.setMaxWidth(x-100);
		Vbox_of_day.getChildren().add(AuthoGUI2);
		//AuthoGUI2.setDisable(true);
        String[] AuthorsInfo3 = new String[3];
		AuthorsInfo3[0] = "Jason S Cong";
		AuthorsInfo3[1] = "Citations: 8394";
		AuthorsInfo3[2] = "Publications: 372";
		AuthoGUI AuthoGUI3 = new AuthoGUI("UsersPNG//Cong.png", AuthorsInfo3, " University of California, Los Angeles" );
		AuthoGUI3.setMaxWidth(x-100);
		Vbox_of_day.getChildren().add(AuthoGUI3);
	//	AuthoGUI3.setDisable(true);
		String[] AuthorsInfo4 = new String[3];
		AuthorsInfo4[0] = "Mahmut Taylan Kandemir";
		AuthorsInfo4[1] = "Citations: 6956";
		AuthorsInfo4[2] = "Publications: 459";
		AuthoGUI AuthoGUI4 = new AuthoGUI("UsersPNG//Mahmut.png", AuthorsInfo4, "Pennsylvania State University" );
		AuthoGUI4.setMaxWidth(x-100);
		Vbox_of_day.getChildren().add(AuthoGUI4);
	//	AuthoGUI4.setDisable(true);

		s.setPrefWidth(x-70 );
		s.setId("s");
		this.setPadding(new Insets(5, 5, 5, 10));
		this.setSpacing(8);
		this.getChildren().addAll(s);
		this.setPrefSize(x-100, y);
		setId("background");

	}

	public VBox getVbox_of_day() {
		return Vbox_of_day;
	}

	public void setVbox_of_day(VBox vbox_of_day) {
		Vbox_of_day = vbox_of_day;
	}

	public switchButton getOn_off() {
		return on_off;
	}

	public void setOn_off(switchButton on_off) {
		this.on_off = on_off;
	}

}
