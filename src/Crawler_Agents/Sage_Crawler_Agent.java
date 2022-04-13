package Crawler_Agents;

import org.jsoup.Jsoup;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;

public class Sage_Crawler_Agent {

	static String Search_Query_Model = "https://journals.sagepub.com/action/doSearch?filterOption=allJournal&AllField=";
	static Scanner search = new Scanner(System.in); 
	static String Searching_Sentence ;
	static String Article_title;
	static String Link_Prefix = "https://journals.sagepub.com";
	static int Page_Number = 1;
	static String Article_numbers ;
	static String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;

	static String results;
	static String results_References;
	static int i = 0;
	
	public static void main(String[] arg) {

		System.out.println("Start MASPER-Tool");
		System.out.print("Input Mot Searching:");  
		Searching_Sentence = search.nextLine();
		
		System.out.print("Enter the number of articles:");  
		Article_numbers = search.nextLine();
		
		  Thread thread = new Thread(){
			    public void run(){
			      System.out.println("Thread Running");
			   
			  
		try {
			file f = new file();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
			LocalDateTime now = LocalDateTime.now();  
			String filename = "Results about "+ Searching_Sentence +dtf.format(now)+".txt";
			String File_References = "References-"+filename;
			f.creat_file( filename);
			f.creat_file( File_References);
			
			for (int page = 0; page < Page_Number; page++) {
				 System.out.println("I = "+i+" | " );
				Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers;
				// Here we create a document object and use JSoup to fetch the website
				Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
				// With the document fetched, we use JSoup's title() method to fetch the title
				Elements articlesFullDoc;
				// Get the list of Selected items in HTML Document.
				articlesFullDoc = doc.select("article[class=searchResultItem]");
				// In case of any IO errors, we want the messages written to the console
				results +="------------ Mot Searching: " + Searching_Sentence +" -------------- \n\n";
				results_References += "------------ Mot Searching: " + Searching_Sentence +" -------------- \n\n";
				for (Element article : articlesFullDoc) {
					// we took articles. now getting informations article by article
					results +="-----------------------| Article "  + i + " |------------------------"+"\n";
					results_References += "--------------------| Article " + i + " |----------------------"+"\n";
	    			try {
						results += "Article Type | " + article.select("span[class= ArticleType]").text()+"\n"
						+ "------------------------------------------------------------------------------------------- \n";
						results += "Publish_Date | " + article.select("span[class= maintextleft]").text()+"\n"
						+ "------------------------------------------------------------------------------------------- \n";
					} catch (Exception e4) {
						}
					try {
						results += "title | " + article.select("span[class= art_title  hlFld-Title]").text()+"\n"
						+ "------------------------------------------------------------------------------------------- \n";
					} catch (Exception e3) {
					}
					try {
						results += "Authors | " + article.select("div[class= header]").text()+"\n"
						+ "------------------------------------------------------------------------------------------- \n";
					} catch (Exception e2) {
						}
				
					try {
						results += "Publiched_Journal | " + article.select("span[class=journal-title]").text()+"\n"
						+ "------------------------------------------------------------------------------------------- \n";
					
					} catch (Exception e1) {
						}
				
					try {
							results += "Article Link Access | " + Link_Prefix + article.select("a[class=ref nowrap]").attr("href")+"\n"
							+ "------------------------------------------------------------------------------------------- \n";
					 
					} catch (Exception e0) {
					}
							
			    	Document doc_Article = Jsoup.connect( Link_Prefix + article.select("a[href]").attr("href")).get(); 
			    	String str = new String(doc_Article.select("h5[class=citing-label]").text()+" ");
			        char[] citations = new char[29];
			    	try {
				    	    str.getChars(0, 28 , citations, 0);
				    	    String TotalCitations = new String(citations);
			    			results += "Total Citations | " + TotalCitations +"\n"
			    					+ "------------------------------------------------------------------------------------------- \n";
			    			results += "Abstract | " + doc_Article.select("div[class=abstractSection abstractInFull]").text()+"\n"
									+ "------------------------------------------------------------------------------------------- \n";
			    			results += "Keywords | " + doc_Article.select("span[class=kwd]").text()+"\n \n \n";
			    	} catch (Exception e0) {
					}
			    	Thread threadReferences = new Thread(){
						    public void run(){
						    	   for (Element ref : doc_Article.select("table[class=references] td[valign=top]")) {
										results_References += "References "+ i + " | "  + ref.text()+"\n";
									} 
						    }
					  };
					  threadReferences.start();
					  //-----------------------------------------------------------------------
					  
					f.Write_in_file( File_References, results_References.split("\n"));	
					results_References="";
					
				f.Write_in_file( filename, results.split("\n"));	
				results="";
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
