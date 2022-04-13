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
 * @author mirame
 */
public class oxford {

    static String Search_Query_Model = "https://academic.oup.com/journals/search-results?&q=";
	static String Searching_Sentence = "sport";
	static String Article_title;
	static String Link_Prefix = "https://academic.oup.com/journals/";
	static int Page_Number = 5;
	static String Article_numbers = "10";
	static String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;

	static String results;
	static String results_References;
	static int i = 0;
	
	public static void main(String[] arg) {

		System.out.println("Start MASPER-Tool");
		
		  Thread thread = new Thread(){
			    public void run(){
			      System.out.println("Thread Running");
			   
			  
		try {
			file f = new file();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
			LocalDateTime now = LocalDateTime.now();  
			String filename = "Result"+dtf.format(now)+".txt";
			String File_References = "References-"+filename;
			f.creat_file( filename);
			f.creat_file( File_References);
			
			for (int page = 1; page < Page_Number; page++) {
				 System.out.println("I = "+i+" | " );
				Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers;
				// Here we create a document object and use JSoup to fetch the website
				Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
				// With the document fetched, we use JSoup's title() method to fetch the title
			//	results += "Title: %s\n" + doc.title()+"\n";
				Elements articlesFullDoc;
				// Get the list of Selected items in HTML Document.
				articlesFullDoc = doc.select("div[class=\"sr-list al-article-box al-normal clearfix\"]");
				// In case of any IO errors, we want the messages written to the console
				for (Element article : articlesFullDoc) {
                                    System.out.println("debut boucle");
					// we took articles. now getting informations article by article
					Article_title = articlesFullDoc.text();
					results += "-----------| " + i + "  |-------------"+"\n";
					results_References+= "-----------| " + i + "  |-------------"+"\n";
	    			try {
						results += "Type | " + article.select("div[class=\"sri-type article-type-display-name at-result-type-label\"]").text()+"\n";
						results += "Date | " + article.select("div[class=\"sri-date al-pub-date\"]").text()+"\n";
					} catch (Exception e4) {
                                            System.out.println("erreur 1");
						}
					try {
						results += "title | " + article.select("span").text()+"\n";
					} catch (Exception e3) {
                                            System.out.println("erreur 2");
					}
					try {
						results += "Authors | " + article.select("div[class=\"sri-authors al-authors-list\"]").text()+"\n";
                                                //results += "Published in | " + article.select("a[href]").text()+"\n";
                                                
					} catch (Exception e2) {
                                            System.out.println("erreur 3");
						}
					try {
                                            //results += "Abstract | " + article.select("section[class=\"abstract\"]").text()+"\n";
						//results += "Total Citations | " + article.select("ul").get(2).text().split(" ")[0]+"\n";
						//results += "Total Downloads | " + article.select("ul").get(2).text().split(" ")[1]+"\n";
					} catch (Exception e1) {
                                            System.out.println("erreur 4");
						}
					try {
						results += "Link | " + article.select("a[href]").attr("href")+"\n";
					} catch (Exception e) {
                                            System.out.println("erreur 5");
				
					}
							
			    	//Document doc_Article = Jsoup.connect( Link_Prefix + article.select("a[href]").attr("href")).get();
				//	results += "Publiched in | " + doc_Article.select("div[class=\"articleDetailsSidebar\"]").get(1).text()+"\n";
                                  //      results += "Keywords | " + doc_Article.select("div[class=\"keywords\"]").text()+"\n";
                                    //    results += "Type | " + doc_Article.select("div[class=\"span8\"]").text()+"\n";
					
				
					
					 
					  //-----------------------------------------------------------------------
					  
					  
					f.Write_in_file( File_References, results_References.split("\n"));	
					results_References="";
					
				f.Write_in_file( filename, results.split("\n"));	
				//results="";
			//	
				 i++;
				}
			}
		} catch (Exception e) {
			System.out.println("============ END ERRER ==========");
		}
                System.out.println(results);
		System.out.println("============ END  ==========");
		   
		
			    }
			  };
			  thread.start();
			  
	}
}
