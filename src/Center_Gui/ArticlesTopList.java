package Center_Gui;

import java.io.File;

import ClassHelprs.Article_GUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ArticlesTopList extends Tab {

	public ArticlesTopList() {
		// TODO Auto-generated constructor stub
		super("Top N Articles");
		
		BorderPane TopNArticlesPane = new BorderPane();
		Text tlogo = new Text("Liste of Top 10 Articles");
		tlogo.setId("logo");
		
		HBox h = new HBox();
		h.setSpacing(10);
		h.getChildren().add(tlogo);
		h.setAlignment(Pos.CENTER);
		h.setPadding(new Insets(10));
		h.setId("panelogo");
		
		Article_GUI Article_GUI1 = new Article_GUI();
		Article_GUI1.setPublicationDate("Date | November 2020");
		Article_GUI1.setArticleTitle("Directly Hit the COVID-19: Research on Online Education under “Suspended Class, Ongoing Learning");
		Article_GUI1.setCitations("0");
		Article_GUI1.setPublicationPlace("Publiched in | ICEEL 2020: 2020 The 4th International Conference on Education and E-Learning");
		Article_GUI1.setPublicationPanceIMG("icons//img1.jpg");
	//	Article_GUI1.setDisable(true);
		Article_GUI Article_GUI2 = new Article_GUI();
		Article_GUI2.setPublicationDate("Date | September 2020");
		Article_GUI2.setArticleTitle(" Digital Education in Times of COVID-19: The Experience of Medical Educators");
		Article_GUI2.setCitations("0");
		Article_GUI2.setPublicationPlace("ICDTE 2020: 2020 The 4th International Conference on Digital Technology in Education");
		Article_GUI2.setPublicationPanceIMG("icons//img2.png");
	//	Article_GUI2.setDisable(true);
		Article_GUI Article_GUI3 = new Article_GUI();
		Article_GUI3.setPublicationDate("Date | November 2020");
		Article_GUI3.setArticleTitle("Analysis of the Impact of COVID-19 on Education Based on Geotagged Twitter");
		Article_GUI3.setCitations("1");
		Article_GUI3.setPublicationPlace("1st ACM SIGSPATIAL International Workshop on Modeling and Understanding the Spread of COVID-19");
		Article_GUI3.setPublicationPanceIMG("icons//img3.jpg");
	//	Article_GUI3.setDisable(true);
		Article_GUI Article_GUI4 = new Article_GUI();
		Article_GUI4.setPublicationDate("Date | September 2020");
		Article_GUI4.setArticleTitle(" Parents' Perceptions of Early Childhood Education Learning in the COVID-19 Pandemic Period");
		Article_GUI4.setCitations("0");
		Article_GUI4.setPublicationPlace("ICLIQE 2020: Proceedings of the 4th International Conference on Learning Innovation and Quality Education");
		Article_GUI4.setPublicationPanceIMG("icons//img4.jpg");
	//	Article_GUI4.setDisable(true);
		
		Article_GUI Article_GUI5 = new Article_GUI();
		Article_GUI5.setPublicationDate("Date | April 2021");
		Article_GUI5.setArticleTitle("The impact of COVID-19 on industry and education: panel discussion");
		Article_GUI5.setCitations("0");
		Article_GUI5.setPublicationPlace("Journal of Computing Sciences in Colleges");
		Article_GUI5.setPublicationPanceIMG("icons//img5.jpg");
	//	Article_GUI5.setDisable(true);
		
		VBox v = new VBox();
		v.setAlignment(Pos.TOP_CENTER);
		v.setId("mainpane2");
		v.setSpacing(5);
		v.getChildren().add(Article_GUI1);
		v.getChildren().add(Article_GUI2);
		v.getChildren().add(Article_GUI3);
		v.getChildren().add(Article_GUI4);
		v.getChildren().add(Article_GUI5);
		
		v.setId("mainpane2");
		v.setPadding(new Insets(10));
		v.setPrefWidth(640);
		
		v.setAlignment(Pos.TOP_CENTER);
		ScrollPane s = new ScrollPane(v);
		s.setId("mainpane2");
	
		TopNArticlesPane.setTop(h);
		TopNArticlesPane.setCenter(s);
		this.setContent(TopNArticlesPane);
	}
}
