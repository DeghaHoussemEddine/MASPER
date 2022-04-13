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

public class UserLefPane extends VBox{
	
		private VBox Vbox_of_day;
		private switchButton on_off;

		public UserLefPane(String words[], double x, double y) {
			super();

			Vbox_of_day = new VBox();
			Vbox_of_day.setPrefSize(x, y);
			Vbox_of_day.setSpacing(10);
			Vbox_of_day.setPadding(new Insets(5, 5, 5, 5));
			Vbox_of_day.setId("backgroundwhiteborder");
			Vbox_of_day.setMaxWidth(x);
			
			String[] AuthorsInfo = new String[3];
			AuthorsInfo[0] = "Dr. Degha Houssem Eddine";
			AuthorsInfo[1] = "ORCID iD: 0000-0002-3401-4473";
			AuthorsInfo[2] = "h-index:   5";
			AuthoGUI AuthoGUI = new AuthoGUI("UsersPNG//houssem.png", AuthorsInfo, "Conected User" );
			AuthoGUI.setMaxWidth(x-100);
			Vbox_of_day.getChildren().add(AuthoGUI);
			
		
			this.setPadding(new Insets(5, 5, 5, 10));
			this.setSpacing(8);
			this.getChildren().addAll(Vbox_of_day);
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
