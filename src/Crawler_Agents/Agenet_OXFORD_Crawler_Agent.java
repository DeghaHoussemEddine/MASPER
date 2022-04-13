package Crawler_Agents;

/*
 *  is has errer in cititaion + publiched in  + authors not separeted
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;


public class Agenet_OXFORD_Crawler_Agent {
	static String Search_Query_Model = "https://academic.oup.com/journals/search-results?q=";
	static String Searching_Sentence;
	static String Article_title;
	static String Link_Prefix = "https://academic.oup.com";
	static int Page_Number=1 ;
	static String Article_numbers="6" ;
	static String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;
	
	static String results;
	static String results_References;
	static int i = 0;
	public static void main(String[] arg) {
		
		System.out.println("Start OXFORD-Crawler-Agent");
		Scanner read =new Scanner(System.in);
		System.out.print("Enter the name of articles that you want searche for: ");
		Searching_Sentence=read.next();
		System.out.print("Enter number of articles that you want searche for: ");
		int NA=read.nextInt()+1;
		Article_numbers=String.valueOf(NA);
		
		
		
		
		
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
			for (int page = 1; page <= Page_Number; page++) {
				
				
				Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers;
				// Here we create a document object and use JSoup to fetch the website
				Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
				// With the document fetched, we use JSoup's title() method to fetch the title
			//	results += "Title: %s\n" + doc.title()+"\n";
				Elements articlesFullDoc;
				// Get the list of Selected items in HTML Document.
				articlesFullDoc = doc.select("div[class=sr-list al-article-box al-normal clearfix]");
				// In case of any IO errors, we want the messages written to the console
				for (Element article : articlesFullDoc) {
					// we took articles. now getting informations article by article
					Article_title = articlesFullDoc.text();
					Document doc_Article = Jsoup.connect(Link_Prefix + article.select("a[href]").attr("href")).get();
										
					results += "-----------| " + i + "  |-------------"+"\n";
					results_References+= "-----------| " + i + "  |-------------"+"\n";
					 
					try {
						//results += "Type | " + article.select("div[class=sr-facet-label]").text()+"\n";
						//System.out.println("Type="+article.select("div[class=sr-facet-label]").text());
						
					} catch (Exception e4) {
						}
					try {
						results += "Date | " + doc_Article.select("div[class=ii-pub-date]").text()+"\n";
						//System.out.println("Date="+doc_Article.select("div[class=ii-pub-date]").text());
						results += "title | " + article.select("[class=article-link at-sr-article-title-link]").text()+"\n";
						//System.out.println("title="+article.select("[class=article-link at-sr-article-title-link]").text());
				
					} catch (Exception e3) {
					}
					try {
						results += "Authors | " + article.select("span[class=wi-fullname brand-fg]").text()+"\n";
						//System.out.println("Aut="+article.select("span[class=wi-fullname brand-fg]").text());
					} catch (Exception e2) {
						}
					try {
						String citaions=article.select("div[class=al-citation-list]").text();
						int counter=0;
						results += "Citations | " + citaions+"\n";
						//System.out.println("Citations="+citaions);
						for (int i=0;i<citaions.length();i++)
							if (citaions.charAt(i)==',') counter++;
						results += "Total Citations | " +counter+"\n";
						//System.out.println("Total Citaions="+counter);
						//results += "Total Downloads | " + article.select("ul").get(2).text().split(" ")[1]+"\n";
						//System.out.println("");
					} catch (Exception e1) {
						}
					try {
						results += "Link | " +Link_Prefix +article.select("a[href]").attr("href") +"\n";
						//System.out.println("Link="+Link_Prefix+article.select("a[href]").attr("href"));
						results += "Link Access | " + Link_Prefix + article.select("a[class=al-link pdf article-pdfLink]").attr("href")+"\n";
						//System.out.println("Link access="+Link_Prefix+ doc_Article.select("a[class=al-link pdf article-pdfLink]").attr("href")); // a with href);
					} catch (Exception e) {
				
					}
							
			    	try {
						String datePub=article.select("div[class=sri-date al-pub-date]").text();
						results += datePub.substring(0,9)+" in |"+datePub.substring(10,datePub.length())+"\n";	
						//System.out.println(datePub.substring(0,9)+" in |"+datePub.substring(10,datePub.length()));
						results += "Abstract | " + doc_Article.select("section[class=abstract]").text()+"\n";
						//System.out.println("Abstract="+doc_Article.select("section[class=abstract]").text()+"\n");
						//System.out.println("Extract="+article.select("div[id=abstract-620973]").text());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Thread threadReferences = new Thread(){
						    public void run(){
						    	
						      for (Element ref : doc_Article.select("div[class=js-splitview-ref-item]")) { 
						    	//for (Element ref: doc_Article.select("div[class=ref-content]")) {
						    	//System.out.println("i="+i);
						results_References += "References "+i+ " | "  + ref.text()+"\n";
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
			System.out.println("============ END ERROR ==========");
		}
		System.out.println("============ END  ==========");
		   
		
			    }
		};
			  thread.start();
			  
			  }

		}



