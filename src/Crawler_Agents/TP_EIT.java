package Crawler_Agents;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;

import java.util.Scanner;


public class TP_EIT {
    
    
	static String Searching_Sentence;
	static String Article_title;
	static String Link_Prefix = "https://onlinelibrary.wiley.com";
	static int Page_Number , Articls_Nombre, i;
        static String Link_Postfix ;
	static String results="";
        static String results_References="";

	
        
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
                        
                        Scanner keyboard = new Scanner(System.in);
                        System.out.print("Searching sentence: ");
                        Searching_Sentence = keyboard.nextLine() ;
                        System.out.print("Article Number: ");
                        Articls_Nombre = keyboard.nextInt() ;
                        System.out.print("Page Number: ");
                        Page_Number = keyboard.nextInt() ;
                        

			for (int page = 0 ; page < Page_Number; page++) {
                            i=1;
			 System.out.println("  Page = "+page+" | " );
                            results += "                        "+"Page "+page+"                     " +"\n";
                            String Link_Prefix_;
                            Link_Prefix_=Link_Prefix +"/action/doSearch?AllField=" ;
	                	Link_Postfix = "&pageSize="+ Articls_Nombre + "&startPage=" + page;
                                
			        Document doc ;
                                doc = Jsoup.connect( Link_Prefix_ + Searching_Sentence + Link_Postfix).get();        
                                
				Elements articlesFullDoc = doc.select("li[class=clearfix separator search__item bulkDownloadWrapper]");
				
				for (Element article : articlesFullDoc) {                               
					
					Article_title = articlesFullDoc.text();
					results += "-----------| Article " + i + "  |-------------"+"\n";
                                         results_References+= "-----------| " + i + "  |-------------"+"\n";
                                        
					try {
				         results += "title : " + article.select("span[class=hlFld-Title]").text()+"\n";  
					} catch (Exception e3) {
                                        }
					try {
						results += "Authors : " + article.select("a[class=publication_contrib_author]").get(0).text()+"\n";
					} catch (Exception e2) {
						}
                                        try {
						results += "First published : " + article.select("p[class=meta__epubDate]").get(0).text()+"\n";
					} catch (Exception e2) {
						}
                                        try {
						results += "Document type : " + article.select("span[class=meta__type]").get(0).text()+"\n";
					} catch (Exception e2) {
						}
                                        try {
						results +=  article.select("div[class=search-collection-items]").get(0).text()+"\n";
					} catch (Exception e2) {
						}
                                        try {
						results += "Article Link Access : " + Link_Prefix + article.select("span[class=hlFld-Title]").select("a[href]").attr("href") +"\n";
					    } catch (Exception e2) {}
				        
							
			     	Document doc_Article = Jsoup.connect( Link_Prefix + article.select("span[class=hlFld-Title]").select("a[href]").attr("href")).get();
					results += "Citations : " + doc_Article.select("div[class=epub-section cited-by-count]").select("a[href]").text()+"\n";
                                        results += "Summary : " +"\n"+ doc_Article.select("div[class=article-section__content en main]").text()+"\n";
				
				            for (Element ref : doc_Article.select("ul[class=rlist separator]"))
                                            {
                                                for (Element reff : ref.select("li"))
                                                {
					            results_References += "References "+i+ " | "  + reff.text()+"\n";
                                                }             
					    }
				
					  
					f.Write_in_file( File_References, results_References.split("\n"));	
					results_References="";
					 
					
				f.Write_in_file( filename, results.split("\n\n"));	
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


