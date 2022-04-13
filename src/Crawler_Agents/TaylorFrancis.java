package Crawler_Agents;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;
import Nodes_Stectures.Article2;

public class TaylorFrancis {

    private String Searching_Sentence = "";
    private int    Page_Number = 1;
	private String Article_numbers = "10";
    private String Link_Prefix = "https://www.tandfonline.com";
    private String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;
    private String Search_Query_Model = "https://www.tandfonline.com/action/doSearch?AllField=";

    private final String ARTICLES_TAG = "article[class=searchResultItem]";
    private final String ARTICLE_TITLE_TAG = "div[class=art_title]";
    private final String ARTICLE_TYPE_TAG = "div[class=article-type]";
    private final String ARTICLE_DATE_TAG = "span[class=publication-year]";
    private final String ARTICLE_PUBLISHEDIN_TAG = "a[class=searchResultJournal no-padding-right]";
    private final String ARTICLE_AUTHORS_TAG = "div[class=author]";
    private final String ARTICLE_LINK_TAG = "a[class=ref nowrap]";
    private final String ARTICLE_LINK_ACCESS_TAG = "li[class=epub-tab]";
    private final String ARTICLE_LINK_DOWNLOAD_TAG = "li[class=pdf-tab]";
    private final String ARTICLE_LINK_REFERENCES_TAG = "a[class=show-references]";
    private final String ARTICLE_REFERENCES_TAG = "ul[class=references numeric-ordered-list]";
    private final String ARTICLE_ABSTRACT_TAG = "div[class=abstractSection abstractInFull]";
    private final String ARTICLE_KEYWORDS_TAG = "div[class=hlFld-KeywordText]";
    private final String ARTICLE_TOTAL_CITATIONS_TAG = "div[class=articleMetricsContainer]";
    //private final String ARTICLE_TOTAL_DOWNLOAD_TAG = "";
    //private final String ARTICLE_TOTAL_VIEWS_TAG = "div[class=articleMetricsContainer]";

    private file f;
    private String articleFile;
    private String referencesFile;
    private int i = 0;


    public TaylorFrancis(){}
    public TaylorFrancis(String Searching_Sentence){
        this.Searching_Sentence = searchTextFormat(Searching_Sentence);
    }
    public TaylorFrancis(String Searching_Sentence, int articleNumbers){
        this.Searching_Sentence = searchTextFormat(Searching_Sentence);
        this.Article_numbers = String.valueOf(articleNumbers);
    }
    public TaylorFrancis(int articleNumbers){
        this.Article_numbers = String.valueOf(articleNumbers);
    }

    public void search(String Searching_Sentence){
        this.Searching_Sentence = searchTextFormat(Searching_Sentence);
        System.out.println("Start of search for : " + Searching_Sentence);

        Thread searchThread = new Thread(){
            public void run(){
                System.out.println("========= Thread Running =========");

                try{

                    createFiles();
                    for (int page = 0; page < Page_Number; page++) {
                        Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers;
                        String url = Search_Query_Model + Searching_Sentence + Link_Postfix;
                        // Here we create a document object and use JSoup to fetch the website
				        Document doc = Jsoup.connect(url).get();
                        Elements articles;
                        // Get the list of Selected items in HTML Document.
                        articles = doc.select(ARTICLES_TAG);

                        // we took articles. now getting informations article by article
                        for (Element articleElement : articles) {
                            Article2 article = new Article2(i);
                            article.setArticleType(articleElement.select(ARTICLE_TYPE_TAG).text());
                            article.setArticlePublishedDate(articleElement.select(ARTICLE_DATE_TAG).text());
                            article.setArticlePublishedIn(articleElement.select(ARTICLE_PUBLISHEDIN_TAG).text());
                            article.setArticleTitle(articleElement.select(ARTICLE_TITLE_TAG).select("span[class=hlFld-Title]").text());
                            article.setArticleAuthors(articleElement.select(ARTICLE_AUTHORS_TAG).text());
                            String articleUrl = Link_Prefix+articleElement.select(ARTICLE_LINK_TAG).attr("href");
                            article.setArticleLink(articleUrl);

                            Document articleDetails  = Jsoup.connect(articleUrl).get();
                            article.setArticleAbstract(articleDetails.select(ARTICLE_ABSTRACT_TAG).text());
                            article.setArticleKeywords(articleDetails.select(ARTICLE_KEYWORDS_TAG).select("a[href]").eachText());
                            String linkAccess = Link_Prefix+articleDetails.select(ARTICLE_LINK_ACCESS_TAG).select("a").attr("href");
                            String linkDawnload = Link_Prefix+articleDetails.select(ARTICLE_LINK_DOWNLOAD_TAG).select("a").attr("href");
                            article.setArticleLinkAccess(linkAccess);
                            article.setArticleDownloadLink(linkDawnload);
                            Elements articleMetrics = articleDetails.select(ARTICLE_TOTAL_CITATIONS_TAG).select("div[class=value]");
                            article.setArticleTotalViews(articleMetrics.get(0).text());
                            article.setArticleTotalCitations(articleMetrics.get(1).text());

                            String articleRefUrl = Link_Prefix + articleDetails.select(ARTICLE_LINK_REFERENCES_TAG).attr("href");
                            Document articleRefs  = Jsoup.connect(articleRefUrl).get();
                            article.setArticleReferences(articleRefs.select(ARTICLE_REFERENCES_TAG).select("li").eachText());

                            String [] art = {article.toString()};
                            f.Write_in_file(articleFile, art);

                            String [] ref = {article.referencesToString()};
                            f.Write_in_file(referencesFile, ref);

                            System.out.println("Article ID = "+i+" | done." );

                            i++;
                        }


                    }
                    

                }catch(Exception e){ System.out.println("============ END ERRER ==========="); }

                System.out.println("============== END ===============");
            }
        };

        searchThread.start();
    }

    public void search(){
        if (Searching_Sentence.isEmpty()){
            System.out.println("Give me searching Sentence first");
        }else{
            search(this.Searching_Sentence);
        }
    }

    private void createFiles(){
        f = new file();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
        LocalDateTime now = LocalDateTime.now();  
        articleFile = "Result"+dtf.format(now)+".txt";
        referencesFile = "References-"+articleFile;
        f.creat_file(articleFile);
        f.creat_file(referencesFile);
    }

    private String searchTextFormat(String Searching_Sentence){
        char space = ' ';
        char plus = '+';
        return Searching_Sentence.replace(space, plus);
    }
}
