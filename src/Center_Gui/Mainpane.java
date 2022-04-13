package Center_Gui;

import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class Mainpane extends TabPane {


	public HomePage HomePage;
	ArticlesTopList ArticlesTopList;

	public Mainpane() {
		super();
		HomePage = new HomePage();
		HomePage.HomePagebuild();
		
		ArticlesTopList = new ArticlesTopList();
		this.getTabs().add(HomePage);
		this.getTabs().add(ArticlesTopList);
	}

	public HomePage getHomePage() {
		return HomePage;
	}

	

}
