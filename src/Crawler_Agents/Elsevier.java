package Crawler_Agents;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;



public class Elsevier {

	static String Search_Query_Model = "https://www.elsevier.com/en-xm/search-results?query=";
	static String Searching_Sentence = "energy";
	static String Article_title;
	static String Link_Prefix = "https://www.elsevier.com/en-xm";
	static int Page_Number = 1;
	static String Article_numbers = "3";
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
			
			for (int page = 0; page < Page_Number; page++) {
				 System.out.println("I = "+i+" | " );
				Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers;
				System.out.println(Search_Query_Model + Searching_Sentence + Link_Postfix);
				// Here we create a document object and use JSoup to fetch the website
				Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
				// With the document fetched, we use JSoup's title() method to fetch the title
				System.out.println(Search_Query_Model + Searching_Sentence + Link_Postfix);
			//	results += "Title: %s\n" + doc.title()+"\n";
				Elements articlesFullDoc;
				// Get the list of Selected items in HTML Document.
				articlesFullDoc = doc.select("div[class=search-result-items]");
				// In case of any IO errors, we want the messages written to the console
				for (Element article : articlesFullDoc) {
					// we took articles. now getting informations article by article
					Article_title = articlesFullDoc.text();
					results += "-----------| " + i + "  |-------------"+"\n";
					results_References+= "-----------| " + i + "  |-------------"+"\n";
	    			try {
						//results += "Type | " + article.select("div[class=issue-heading]").text()+"\n";
						results += "Date | " + article.select("span[class= book-result-published]").get(0).text()+"\n";
                                                results += "Publiched in | " + article.select("span[class= book-result-published]").text()+"\n";
					} catch (Exception e4) {
						}
					try {
						results += "title | " + article.select("h2[class=search-result-title]").get(0).text()+"\n";
					} catch (Exception e3) {
					}
					try {
						results += "Authors | " + article.select("ul").get(0).text()+"\n";
					} catch (Exception e2) {
						}
					
					try {
						results += "Link | " +  article.select("a[href]").attr("href")+"\n";
						
                                     
					} catch (Exception e) {
				
					}
							
			    	Document doc_Article = Jsoup.connect(  article.select("a[href]").attr("href")).get();
                                        
					results += "Abstract | " + doc_Article.select("details[class=AccordionItem_details__1jTtY]").attr("div")+"\n";
                                        
					  Thread threadReferences = new Thread(){
						    public void run(){
						   
	      
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
