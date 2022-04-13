package ClassHelprs;

import java.io.File;

import eu.hansolo.tilesfx.Demo;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.Tile.ImageMask;
import eu.hansolo.tilesfx.Tile.SkinType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Article_GUI extends VBox {

	private Tile imageCounterTile;
	private static final double TILE_WIDTH = 550;
	private static final double TILE_HEIGHT = 120;

	private String PublicationDate;
	private String ArticleTitle;
	private String Citations;
	private String PublicationPlace;
	private String publicationPanceIMG;

	public Article_GUI() {

		// TODO Auto-generated constructor stub
		HBox H = new HBox();
		H.setSpacing(5);
		H.setPadding(new Insets(2));

		imageCounterTile = TileBuilder.create().skinType(SkinType.IMAGE_COUNTER).prefSize(TILE_WIDTH, TILE_HEIGHT)
				.title("Date | November 2020").alertMessage("15")

				.value(0).unit("Citations").tickLabelDecimals(10).referenceValue(2)
				.text("Publiched in | ICEEL 2020: 2020 The 4th International Conference on Education and E-Learning")
				.description(
						"Title : Directly Hit the COVID-19: Research on Online Education under “Suspended Class, Ongoing Learning\r\n"
								+ "")
				.image(new Image(new File("icons\1.png").toURI().toString())).imageMask(ImageMask.ROUND).build();

		GridPane gridPane = new GridPane();
		gridPane.setPrefWidth(250);
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		Text Title = new Text("Title : Digital Education in Times of COVID-19: ");
		Text Authors = new Text("Authors : Jesus Alfonso Beltran-Sanchez,");
		Text PublichedIn = new Text("Publiched in : ");

		gridPane.add(Title, 0, 0);
		gridPane.add(Authors, 0, 1);
		gridPane.add(PublichedIn, 0, 2);

		H.getChildren().addAll(imageCounterTile);
		H.setAlignment(Pos.TOP_CENTER);
		this.getChildren().add(H);
		// this.setAlignment(Pos.TOP_CENTER);
		// this.setPrefSize(550, 150);
		// this.setId("backgroundwhite");
		// this.setMaxSize(550, 150);
		this.setId("mainpane2");
	}

	public Tile getImageCounterTile() {
		return imageCounterTile;
	}

	public void setImageCounterTile(Tile imageCounterTile) {

		this.imageCounterTile = imageCounterTile;
	}

	public String getPublicationDate() {
		return PublicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		PublicationDate = publicationDate;
		imageCounterTile.setTitle(publicationDate);
	
	}

	public String getArticleTitle() {
		return ArticleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		ArticleTitle = articleTitle;

		imageCounterTile.setDescription(articleTitle);

	}

	public String getCitations() {
		return Citations;
	}

	public void setCitations(String citations) {
		Citations = citations;

		imageCounterTile.setValue(Integer.valueOf(citations));

	}

	public String getPublicationPlace() {
		return PublicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		PublicationPlace = publicationPlace;

		imageCounterTile.setText(publicationPlace);
	}

	public String getPublicationPanceIMG() {
		return publicationPanceIMG;
	}

	public void setPublicationPanceIMG(String publicationPanceIMG) {

		imageCounterTile.setImage(new Image(new File(publicationPanceIMG).toURI().toString()));

		this.publicationPanceIMG = publicationPanceIMG;
	}

}
