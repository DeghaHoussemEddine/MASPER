package Crawler_Agents;





import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.IsEmpty;

import ClassHelprs.file;

public class oxford_academic {



	static String Search_Query_Model = "https://academic.oup.com/journals/search-results?&q=";
			
	static String Searching_Sentence = "education";
	static String Article_title;
	static String Link_Prefix = "https://academic.oup.com/";
	static int Page_Number = 2;
	static String Article_numbers = "3";
	static String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;
	//https://dl.acm.org/action/doSearch?AllField=education+covid-19%20&startPage=1&pageSize=%201
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
				// Here we create a document object and use JSoup to fetch the website
				Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
				// With the document fetched, we use JSoup's title() method to fetch the title
			//	results += "Title: %s\n" + doc.title()+"\n";
				
				Elements articlesFullDoc;
				// Get the list of Selected items in HTML Document.
				articlesFullDoc = doc.select("div[class=sr-list al-article-box al-normal clearfix]");
				// In case of any IO errors, we want the messages written to the console
				 Elements links= doc.select("a[class=showAbstractLink js-show-abstract]");
				 System.out.println(doc.select("div[class=sr-list al-article-box al-normal clearfix]").text());
		//		  for (Element link : links) {  
					//  System.out.println(Search_Query_Model + Searching_Sentence + Link_Postfix);
					// if (link.attr("class")== "master-container js-master-container") {
		     //           System.out.println("\nlink : " + link.attr("class"));  
		    //            System.out.println("text : " + link.text());  
		  //          }  
				
				for (Element article : articlesFullDoc) {
					// we took articles. now getting informations article by article
					Article_title = articlesFullDoc.text();
					results += "-----------| " + i + "  |-------------"+"\n";
					results_References+= "-----------| " + i + "  |-------------"+"\n";
	    			try {
					//	results += "Type | " + article.select("div[class=issue-heading]").text()+"\n";
					
	    				results += "Date | " + article.select("div[class= sri-date al-pub-date]").text()+"\n";
	    				System.out.println(doc.select("div[class= sri-date al-pub-date]").text());
	    			} catch (Exception e4) {
						System.out.println("ff");
						}
					try {
						results += "title | " + article.select("h4[class=sri-title customLink al-title at-sr-item-title-link]").text()+"\n";
						System.out.println(doc.select("h4[class=sri-title customLink al-title at-sr-item-title-link]").text());
					} catch (Exception e3) {
					}
					try {
						results += "Authors | " + article.select("div[class=sri-authors al-authors-list]").text()+"\n";
						System.out.println(doc.select("div[class=sri-authors al-authors-list]").text());
					} catch (Exception e2) {
						}
					try {
					//	results += "Total Citations | " + article.select("ul").get(2).text().split(" ")[0]+"\n";
					//	results += "Total Downloads | " + article.select("ul").get(2).text().split(" ")[1]+"\n";
					} catch (Exception e1) {
						}
					try {
						results += "Link | " + Link_Prefix + article.select("a[href]").attr("href")+"\n";
						System.out.println(results);
						results += "Link Access | " +Search_Query_Model + Searching_Sentence + Link_Postfix+"\n";
						System.out.println(results);
					} catch (Exception e) {
				
					}
							
			    //	Document doc_Article = Jsoup.connect( Link_Prefix + article.select("a[href]").text()).get();
					results += "Publiched in | " + article.select("div[class=al-citation-list]").text()+"\n";
					System.out.println( "Publiched in | " + article.select("div[class=al-citation-list]").text());
					results += "Abstract | " + article.select("div[class=snippet]").text()+"\n";
					System.out.println("Abstract | " + article.select("div[class=snippet]").text());
				   
					  Thread threadReferences = new Thread(){
						    public void run(){
						   
				//		      for (Element ref : doc_Article.select("span[class=references__note]")) {
				//		results_References += "References "+i+ " | "  + ref.text()+"\n"; }
						      
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


