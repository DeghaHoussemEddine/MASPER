package Crawler_Agents;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;

public class MDPIAgent {
	static String Search_Query_Model = "https://www.mdpi.com/search?sort=";
	static String Searching_Sentence = "covid";
	static String Article_title;
	static String Link_Prefix = "https://www.mdpi.com/";
	static int Page_Number = 2;
	static String Article_numbers = "3";
                                                   
	static String Link_infix = "pubdate&page_no=" + Page_Number + "&page_count=" + Article_numbers+"&q=";

	static String results;
	static String results_References;
	static int i = 1;
	
	public static void main(String[] arg) {

		System.out.println("Start MASPER-Tool");
		
		  Thread thread = new Thread(){
			    public void run(){
			      System.out.println("Thread Running");
			   
			  
		try {
			file f = new file();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
			LocalDateTime now = LocalDateTime.now();  
			String filename = "Result MDPI"+dtf.format(now)+".txt";
			String File_References = "References-"+filename;
			f.creat_file( filename);
			f.creat_file( File_References);
			System.out.println(Search_Query_Model + Link_infix + Searching_Sentence );
			for (int page = 1; page < Page_Number; page++) {
				 System.out.println("I = "+i+" | " );
				 				 
				Link_infix = "pubdate&page_no=" + page + "&page_count=" + Article_numbers+"&q=";
				// Here we create a document object and use JSoup to fetch the website
				Document doc = Jsoup.connect(Search_Query_Model + Link_infix + Searching_Sentence ).get();
				// With the document fetched, we use JSoup's title() method to fetch the title

				//	results += "Title: %s\n" + doc.title()+"\n";
				Elements articlesFullDoc;
				// Get the list of Selected items in HTML Document.
				articlesFullDoc = doc.select("div[class=generic-item article-item]");
				// In case of any IO errors, we want the messages written to the console
				for (Element article : articlesFullDoc) {
					
					// we took articles. now getting informations article by article
					Article_title = articlesFullDoc.text();
                                        System.out.println(Article_title);
					results += "-----------| " + i + "  |-------------"+"\n";
					
	    			try {
						results += "Type | " + article.select("span[class=label articletype]").text()+"\n";
                                                       String date = article.select("div[class= color-grey-dark]").text();
						results += "Date | " + date.substring(date.length()-12) +"\n";
					} catch (Exception e4) {
						}
					try {
						results += "title | " + article.select("a[class=title-link]").text()+"\n";
					} catch (Exception e3) {
					}
					try {    
                                                       results += "Authors | ";
                                                       for(Element author :article.select("span[class=sciprofiles-link__name]"))
						            results += author.text()+"; ";
                                                       results +="\n";
					} catch (Exception e2) {
						}
					try {
						results += "Access | " + article.select("span[class=label openaccess]").get(0).text()+"\n";
					} catch (Exception e1) {
						}
					try {
						
                                                       results += "Link | " +Link_Prefix +article.select("a[class=title-link]").attr("href") +"\n";
                                                
						results += "Link Access(download) | " + Link_Prefix + article.select("a[href]").attr("href")+"\n"; 
					} catch (Exception e) {
				
					}
                                             
						
                                                       String add =Link_Prefix + article.select("a[class=title-link]").attr("href");	
			    	                    Document doc_Article = (Document) Jsoup.connect( add).get();
                              
					results += "Publiched by | " + doc_Article.select("div[class=affiliation-name]").text()+"\n";
                                                    
					results += "Abstract | " + article.select("div[class=abstract-full]").text()+"\n";
				
					results_References+= "-----------| " + i + "  |-------------"+"\n";
						
					Thread threadReferences = new Thread(){
						    public void run(){
						      
						      Element ref = doc_Article.select("div[class=in-tab]").get(0) ;
                                                       
						results_References += "References "+i+ " | "  + ref.text()+"\n";
					
						      
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
	
		  