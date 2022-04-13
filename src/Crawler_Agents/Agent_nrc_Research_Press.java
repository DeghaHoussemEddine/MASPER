package Crawler_Agents;
/*
 *  he has no citatioms and download data + bad references order !
 */
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

//import org.json.parser.JSONParser;
//import org.json.parser.ParseException;

public class Agent_nrc_Research_Press {
	
	static String Search_Query_Model = "https://cdnsciencepub.com/action/doSearch?AllField=";
	//static String Searching_Sentence ;
	static String Article_title;
	static String Link_Prefix = "https://cdnsciencepub.com";
	static int Page_Number = 1;
	static String Article_numbers = "2";
	static String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;

	static String results;
	static String results_References;
	static int i = 0;
	
	public static void main(String[] arg) {

		System.out.println("");
		Scanner Sc= new Scanner(System.in); 
		System.out.print("Enter the Subject:  ");  
		String Searching_Sentence= Sc.nextLine();
		System.out.println("Subject is: " + Searching_Sentence);  // Output user input
	  
		
		  Thread thread = new Thread(){
			    public void run(){
			      System.out.println("Thread Running");
			   
			  
		try {
			file f = new file();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
			LocalDateTime now = LocalDateTime.now();  
			String filename = "cdnsciencepub.com- Result"+dtf.format(now)+".txt";
			String File_References = "cdnsciencepub.com-References-"+filename;
			f.creat_file( filename);
			f.creat_file( File_References);
			
			for (int page = 0; page < Page_Number; page++) {
				 System.out.println("I = "+i+" | " );
				Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers;
				// Here we create a document object and use JSoup to fetch the website
				Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
				// With the document fetched, we use JSoup's title() method to fetch the title
			//	results += "Title: %s\n" + doc.title()+"\n";
				Elements articlesFullDoc;
				// Get the list of Selected items in HTML Document.
				articlesFullDoc = doc.select("li[class=issue-item]");
				//System.out.println(articlesFullDoc);
				// In case of any IO errors, we want the messages written to the console
				for (Element article : articlesFullDoc) {
					// we took articles. now getting informations article by article
					Article_title = articlesFullDoc.text();
					results += "-----------| " + i + "  |-------------"+"\n";
					results_References+= "-----------| " + i + "  |-------------"+"\n";
	    			try {
						//results += "Type | " + article.select("div[class=issue-heading]").text()+"\n";
						
					} catch (Exception e4) {
						}
					try {
						results += "title | " + article.select("div[class=issue-item__title]").text()+"\n";
						//System.out.println(article.select("div[class=issue-item_title]"));
					} catch (Exception e3) {
					}
					try {
						results += "Authors | " + article.select("ul").get(0).text()+"\n";
						results += "Abstract | " + article.select("div[class=issue-item__abstract]").text()+"\n";
					} catch (Exception e2) {
						}
					try {
						//results += "Total Citations | " + article.select("ul").get(2).text().split(" ")[0]+"\n";
						//results += "Total Downloads | " + article.select("span[menu-total-value]").get(2).text().split(" ")[1]+"\n";
					} catch (Exception e1) {
						}
					try {
						results += "Link | " + Link_Prefix + article.select("a[href]").attr("href")+"\n";
						results += "Link Access | " + Link_Prefix + article.select("a[class=content-type content-type--pdf]").attr("href")+"\n";
					} catch (Exception e) {
				
					}
							
			    	Document doc_Article = Jsoup.connect( Link_Prefix + article.select("a[href]").attr("href")).get();
			    	
			   
			    	results += "Date | " + doc_Article.select("span[property=datePublished]").get(0).text()+"\n";
					results += "Publiched in | " + doc_Article.select("span[property=isPartOf]").text()+"\n";
					
					  Thread threadReferences = new Thread(){
						    public void run(){
						   
						      for (Element ref : doc_Article.select("section[id=bibliography]")) {
						results_References += "References "+i+ " | "  + ref.text()+"\n"+"\n";
					}
						      
						    }
					  };
					  threadReferences.start();
					  //-----------------------------------------------------------------------
					  
					  
					f.Write_in_file( File_References, results_References.split("\n"));	
					results_References="";
					
				f.Write_in_file( filename, results.split("\n"));	
				results="";	
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
