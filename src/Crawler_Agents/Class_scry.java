/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crawler_Agents;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;

/**
 *
 * @author User
 */
public class Class_scry {

    static String Search_Query_Model = "https://onlinelibrary.wiley.com/action/doSearch?AllField=";
    static String Searching_Sentence = "covid";
    static String Article_title;
    static String Link_Prefix = "https://onlinelibrary.wiley.com";
    static int Page_Number = 1;
    static String Article_numbers = "1";
    static String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;

    static String results;
    static String results_References;
    static int i = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start MASPER-Tool");

        Thread thread = new Thread() {
            public void run() {
                System.out.println("Thread Running");

                try {
                    file f = new file();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
                    LocalDateTime now = LocalDateTime.now();
                    String filename = "Result" + dtf.format(now) + ".txt";
                    String File_References = "References-" + filename;
                    f.creat_file(filename);
                    f.creat_file(File_References);

                    for (int page = 0; page < Page_Number; page++) {
                        System.out.println("I = " + i + " | ");
                        //Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers;
                        // Here we create a document object and use JSoup to fetch the website
                        Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence+Link_Postfix ).get();
                        // With the document fetched, we use JSoup's title() method to fetch the title
                        //	results += "Title: %s\n" + doc.title()+"\n";
                        Elements articlesFullDoc;
                        // Get the list of Selected items in HTML Document.
                        articlesFullDoc = doc.select("div[class=item__body]");
                        // In case of any IO errors, we want the messages written to the console
                        for (Element article : articlesFullDoc) {
                            // we took articles. now getting informations article by article
                            Article_title = articlesFullDoc.text();
                            results += "-----------| " + i + "  |-------------" + "\n";
                            results_References += "-----------| " + i + "  |-------------" + "\n";
                            try {
                            results += "Type | " + article.select("span[class=meta__type]").text() + "\n";
                            results += "Date | " + article.select("p[class= meta__epubDate]").text() + "\n";
                            } catch (Exception e4) {
                            }
                            try {
                                results += "title | " + article.select("h2[class=meta__title meta__title__margin]").text() + "\n";
                            } catch (Exception e3) {
                            }
                            try {
                             results += "Authors | " + article.select("a[class=publication_contrib_author]").get(0).text() + "\n";
                            } catch (Exception e2) {
                            }
                            try {
                             results += "Total Citations | " + article.select("ul[class=rlist cited-by__list]").get(2).text().split(" ")[0] + "\n";
                                //results += "Total Downloads | " + article.select("ul").get(2).text().split(" ")[1] + "\n";
                            } catch (Exception e1) {
                            }
                            try {
                                results += "Link | " + Link_Prefix + article.select("a[href]").attr("href") + "\n";
                                results += "Link Access | " + Link_Prefix + article.select("a[class=get-access]").attr("href") + "\n";
                            } catch (Exception e) {

                            }

                            Document doc_Article = Jsoup.connect(Link_Prefix + article.select("a[href]").attr("href")).get();
                            //results += "Publiched in | " + doc_Article.select("span[class=epub-section__title]").text() + "\n";
                            results += "Abstract | " + doc_Article.select("div[class=abstract-group]").text() + "\n";

                            Thread threadReferences = new Thread() {
                                public void run() {
                                    //extra-links

                                    for (Element ref : doc_Article.select("span[class=otherTitle]")) {
                                        results_References += "References " + i + " | " + ref.text() + "\n";
                                    }

                                }
                            };
                            threadReferences.start();
                            //-----------------------------------------------------------------------

                            f.Write_in_file(File_References, results_References.split("\n"));
                            results_References = "";

                            f.Write_in_file(filename, results.split("\n"));
                            results = "";
                            //	
                            i++;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("============ END ERRER ==========");
                }
                System.out.println("============ END  ==========");

            }
        };
        thread.start();

    }

}
