
package Crawler_Agents;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TimerTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

import ClassHelprs.DynamicTable;
import ClassHelprs.Liste;
import ClassHelprs.file;
import Nodes_Stectures.Article;
import Nodes_Stectures.Author;
import Nodes_Stectures.Journal;
import Nodes_Stectures.Reference;
import application.Main;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;

public class Controled_ACM_Crawler_Agent {

	private String default_profile_img = "https://dl.acm.org/pb-assets/icons/DOs/default-profile-1543932446943.svg";
	private boolean FrstCrawle = false;
	private String[] Columns;
	private ArrayList<String[]> Data_input;
	private ArrayList<Article> Articles;

	private String Search_Query_Model;
	private String Search_Full_Query;

	private String Article_title;
	private String Link_Prefix;
	private int Page_Number;
	private String Article_numbers;

	private String results;
	private String results_References;
	private int i;
	private String Link_Postfix;
	private String Searching_Sentence = "";
	BorderPane HomePage;
	Main App;

	public Controled_ACM_Crawler_Agent(Main App) {

		// TODO Auto-generated constructor stub
		this.App = App;
		Search_Query_Model = "https://dl.acm.org/action/doSearch?AllField=";
		Link_Prefix = "https://dl.acm.org";
		Page_Number = 1;
		Article_numbers = "10";
		i = 0;
		Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;

		Columns = new String[9];
		Data_input = new ArrayList<String[]>();
		Articles = new ArrayList<Article>();

		Columns[0] = "iD";
		Columns[1] = "Type";
		Columns[2] = "Date";
		Columns[3] = "Title";
		Columns[4] = "Authors";
		Columns[5] = "Total Citations";
		Columns[6] = "Total Downloads";
		Columns[7] = "Link Access";
		Columns[8] = "Publiched in";

	}

	public String[] CopyDataFromObj(Article Article) {

		String[] DataRaw = new String[9];
		DataRaw[0] = Article.getiD();
		DataRaw[1] = Article.getType();
		DataRaw[2] = Article.getPubliched_date();
		DataRaw[3] = Article.getTitle();
		DataRaw[4] = Article.getFull_Authors();
		DataRaw[5] = Article.getCitations() + "";
		DataRaw[6] = Article.getDownloads() + "";
		DataRaw[7] = Article.getLink_Access();
		DataRaw[8] = Article.getJournal().getTitle();

		return DataRaw;
	};

	public Boolean Crawling(String arg, Timeline animation, Main App) {

		Searching_Sentence = arg;

		TimerTask task = new TimerTask() {
			public void run() {

				try {

					Page_Number = Integer.valueOf(App.getRightpane().getPageField().getText());
					Article_numbers = App.getRightpane().getArticlesMountField().getText();

					Platform.runLater(new Runnable() {
						public void run() {

							try {
								App.getRightpane().getGauge27().setValue(0);

							} catch (Exception e) {

							}

						}
					});

					file f = new file();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
					LocalDateTime now = LocalDateTime.now();
					String filename = "ACM_Result-" + dtf.format(now) + ".txt";
					String File_References = "ACM_References-" + filename;
				
					if (App.getRightpane().getProperties_Engine().getFileSave().isState() == true) {
					
							f.creat_file(filename);
							f.creat_file(File_References);
				
				}
					
					
					for (int page = 0; page < Page_Number; page++) {

						Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers + "&AfterYear="
								+ String.valueOf(App.getRightpane().getStartDateVal()).substring(0, 4) + "&BeforeYear="
								+ String.valueOf(App.getRightpane().getStopDataVal()).substring(0, 4);
						Search_Full_Query = Search_Query_Model + Searching_Sentence + Link_Postfix;
						System.out.print(Search_Full_Query);
						Document doc = Jsoup.connect(Search_Full_Query).get();
						Elements articlesFullDoc;
						articlesFullDoc = doc.select("div[class=issue-item issue-item--search clearfix]");
//------------------------------------------- Filling the Right Pane [with Authors data and Journals List]-----------------------------------------------------------------------------------
						if (FrstCrawle == false) {
							Elements JournalsFullDoc;
							App.getRightpane().getSelectByJournals().getItems().removeAll();
							JournalsFullDoc = doc.select("div[id=Journal/MagazineNames]");
							for (Element JournalAll : JournalsFullDoc.select("ul[class=rlist facet__list]")
									.select("li")) {
								String j = JournalAll.text();
								App.getRightpane().getSelectByJournals().getItems().add(j);
							}

							Elements AuthorsFullDoc;
							App.getRightpane().getSelectByAuthors().getItems().removeAll();
							AuthorsFullDoc = doc.select("div[id=Authors]");
							for (Element Authors : AuthorsFullDoc.select("ul[class=rlist facet__list]").select("li")) {
								String j = Authors.text();
								App.getRightpane().getSelectByAuthors().getItems().add(j);
							}
							FrstCrawle = true;
						}
//------------------------------------------------------------------------------------------------------------------------------

						for (Element article : articlesFullDoc) {

							Article Article = new Article();
							Article_title = articlesFullDoc.text();
							results += "-----------| " + i + "  |-------------" + "\n";
							Article.setiD(i + "");
							results_References += "-----------| " + i + "  |-------------" + "\n";
							try {
								String Type = article.select("div[class=issue-heading]").text();
								results += "Type | " + Type + "\n";
								Article.setType(Type);

								String Date = article.select("div[class= bookPubDate simple-tooltip__block--b]").text();
								results += "Date | " + Date + "\n";
								Article.setPubliched_date(Date);

								String Title = article.select("span[class=hlFld-Title]").text();
								results += "title | " + Title + "\n";
								Article.setTitle(Title);

								String Authors = article.select("ul").get(0).text();
								results += "Authors | " + Authors + "\n";
								Article.setFull_Authors(Authors);

								String Link = Link_Prefix + article.select("a[class=get-access]").attr("href");
								results += "Link Access | " + Link + "\n";
								Article.setLink_Access(Link);

							} catch (Exception e2) {
							}
							try {
								String Citations = article.select("ul").get(2).text().split(" ")[0];
								results += "Total Citations | " + Citations + "\n";
								Article.setCitations(Integer.valueOf(Citations));

								String Downloads = article.select("ul").get(2).text().split(" ")[1];
								results += "Total Downloads | " + Downloads + "\n";
								Article.setDownloads(Integer.valueOf(Downloads));

							} catch (Exception e1) {
							}

							Document doc_Article = Jsoup.connect(Link_Prefix + article.select("a[href]").attr("href"))
									.get();
							Journal Journal = new Journal();
							String Publiched = doc_Article.select("span[class=epub-section__title]").text();
							results += "Publiched in | " + Publiched + "\n";
							Journal.setTitle(Publiched);
							Article.setJournal(Journal);

							String Abstract = doc_Article.select("div[class=abstractSection abstractInFull]").text();
							results += "Abstract | " + Abstract + "\n";
							Article.setAbstract(Abstract);

							Elements keywords = doc_Article.select("ol[class=rlist level-3 ch-1 hasNodes]")
									.select("div");
							for (int z = 0; z < keywords.size(); z++) {
								String keyword = keywords.get(z).text();
								results += "Index Terms | " + keyword + "\n";
								;

								Article.getKeywords().add("");
							}
//-------------------------------------------------------- Download References -------------------------------------------------------------------
							if (App.getRightpane().getProperties_Engine().getDownload_Ref().isState() == true) {
								Thread threadReferences = new Thread() {
									public void run() {

										for (Element ref : doc_Article.select("span[class=references__note]")) {
											results_References += "References " + i + " | " + ref.text() + "\n";
											Reference Reference = new Reference("");
											Article.getReferences().add(Reference);
										}

									}
								};

								threadReferences.start();
							}
//---------------------------------------------------- Geting Authors IMGS + DATA ------------------------------------------------------------------------						
							if (App.getRightpane().getProperties_Engine().getDownload_Authors().isState() == true) {
								for (int k = 0; k < article.select("ul").get(0).select("img[class=author-picture]")
										.size(); k++) {

									URL url = new URL(article.select("ul").get(0).select("img[class=author-picture]")
											.get(k).absUrl("src"));

									Author Author = new Author(
											article.select("ul").get(0).select("a").get(k).attr("title"),
											url.getPath());
									Article.getAuthor().add(Author);

									if (!default_profile_img.equals(article.select("ul").get(0)
											.select("img[class=author-picture]").get(k).absUrl("src"))) {

										downloadFile(url,
												"UsersPNG\\"
														+ article.select("ul").get(0).select("a").get(k).attr("title")
														+ ".jpg");

										// }

										// Document Author_Profile = Jsoup.connect(Link_Prefix
										// +article.select("ul").get(0).select("a[href]").get(0).absUrl("href")).get();

										// System.out.println(article.select("ul").get(0).select("a[href]").get(0).absUrl("href"));

										/*
										 * String Author_Profile_Citations =
										 * article.select("div[class=bibliometrics__count]").select("span").get(1).text(
										 * ); String Author_Profile_Publications_Count =
										 * article.select("div[class=bibliometrics__count]").select("span").get(2).text(
										 * );
										 */
									}
								}
							}
//----------------------------------------------------- Save results in File -----------------------------------------------------------------------						
							if (App.getRightpane().getProperties_Engine().getFileSave().isState() == true) {
									f.Write_in_file(File_References, results_References.split("\n"));
								results_References = "";

								f.Write_in_file(filename, results.split("\n"));
								results = "";
								//
							}
//----------------------------------------------------------------------------------------------------------------------------

							i++;
							Articles.add(Article);
							Data_input.add(CopyDataFromObj(Article));
							App.getMenu_Actions().getData_input().add(CopyDataFromObj(Article));
							Platform.runLater(new Runnable() {
								public void run() {

									try {
										App.getRightpane().getGauge27()
												.setValue(App.getRightpane().getGauge27().getValue() + 1);

									} catch (Exception e) {

									}

								}
							});
						}

					}

					DynamicTable DynamicTable = new DynamicTable(Columns);
					DynamicTable.buildData(Data_input);

					Platform.runLater(new Runnable() {
						public void run() {

							try {
								App.getMainpane().getHomePage().getHomePage().setCenter(DynamicTable.getTableView());
								animation.stop();

							} catch (Exception e) {

							}

						}
					});
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("============ END  ==========");

			}
		};
		try {
			new Thread(task).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public static void downloadFile(URL url, String outputFileName) throws IOException {
		File f = new File(outputFileName);
		if (!f.exists()) {
			try (InputStream in = url.openStream();
					ReadableByteChannel rbc = Channels.newChannel(in);
					FileOutputStream fos = new FileOutputStream(f.getAbsoluteFile())) {
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			}
		}
	}

	public static void downloadFile2(URL url, String fileName) throws Exception {
		try (InputStream in = url.openStream()) {
			Files.copy(in, Paths.get(fileName));
		}
	}

	public String[] getColumns() {
		return Columns;
	}

	public void setColumns(String[] columns) {
		Columns = columns;
	}

	public ArrayList<Article> getArticles() {
		return Articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		Articles = articles;
	}

	public String getSearch_Query_Model() {
		return Search_Query_Model;
	}

	public void setSearch_Query_Model(String search_Query_Model) {
		Search_Query_Model = search_Query_Model;
	}

	public String getSearch_Full_Query() {
		return Search_Full_Query;
	}

	public void setSearch_Full_Query(String search_Full_Query) {
		Search_Full_Query = search_Full_Query;
	}

	public String getArticle_title() {
		return Article_title;
	}

	public void setArticle_title(String article_title) {
		Article_title = article_title;
	}

	public String getLink_Prefix() {
		return Link_Prefix;
	}

	public void setLink_Prefix(String link_Prefix) {
		Link_Prefix = link_Prefix;
	}

	public int getPage_Number() {
		return Page_Number;
	}

	public void setPage_Number(int page_Number) {
		Page_Number = page_Number;
	}

	public String getArticle_numbers() {
		return Article_numbers;
	}

	public void setArticle_numbers(String article_numbers) {
		Article_numbers = article_numbers;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getResults_References() {
		return results_References;
	}

	public void setResults_References(String results_References) {
		this.results_References = results_References;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getLink_Postfix() {
		return Link_Postfix;
	}

	public void setLink_Postfix(String link_Postfix) {
		Link_Postfix = link_Postfix;
	}

	public String getSearching_Sentence() {
		return Searching_Sentence;
	}

	public void setSearching_Sentence(String searching_Sentence) {
		Searching_Sentence = searching_Sentence;
	}
}
