/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crawler_Agents;

/**
 *
 * @author lila
 */import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Locale;

public class ACM_crawler_Agent_functio {
    
         String Search_Query_Model = "https://www.liebertpub.com/action/doSearch?AllField=";
	 String Article_title;
	 String Link_Prefix = "https://www.liebertpub.com";
	 int Page_Number ;
	 String Article_numbers ;
	 String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;
         String results="";
         String total_results="";
	 String results_References="";
	 int i = 0;
         String result_interface;
         String results_citation="";
         String  key_word="";
         String journal="";
         String Type="";
        String Searching_Sentence="";
     void ACM_crawler_Agent_functio(){
         i = 0;
         Searching_Sentence="";
    System.out.println("Start MASPER-Tool");
                    Thread thread = new Thread(){
			    public void run(){
			     

		try {
                           Document doc0 = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
			   total_results = doc0.select("div[class=pull-left search__result search__result--space]").text();
                           //total_results = articlesFullDoc0.select("div[class= pull-left search__result search__result--space]").text();
                          
			for (int page = 0; page < Page_Number; page++) {
				 System.out.println("I = "+i+" | " );
				Link_Postfix = "&startPage=" + page + "&pageSize=" + Article_numbers;
                             	Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
                                Elements articlesFullDoc;
				// Get the list of Selected items in HTML Document.
				articlesFullDoc = doc.select("div[class=article-meta]");
           				// In case of any IO errors, we want the messages written to the console
				for (Element article : articlesFullDoc) {

					// we took articles. now getting informations article by article
					results += "\n-----------| Result: " + i + "  |-------------"+"\n";
	    			try {

                                    	results += "1: Date | " +article.select("span[class= meta__epubDate]").text()+"\n";
					} catch (Exception e4) {
						}
                                
				try {
						results += "2: title | " + article.select("h5[class=meta__title meta__title__margin]").text()+"\n";
					} catch (Exception e3) {

					}
					try {
						results += "3: Authors | " + article.select("ul").get(0).text()+"\n";
					} catch (Exception e2) {

						}
					
                                        try {
                                                results += "4: Abstract | " + article.select("div[class=accordion__content]").text()+"\n";
                                
					} catch (Exception e1) {
                                           System.out.println("absttttt");

                                        }
					try {

						results += "5: Link | " + Link_Prefix + article.select("a[href]").attr("href")+"\n";
						results += "6: Link Access | " + Link_Prefix + article.select("a[class=get-access]").attr("href")+"\n";
					} catch (Exception e) {
                                            System.out.println("liiiiink");

				
					}
							
                                    Document doc_Article = Jsoup.connect( Link_Prefix + article.select("a[href]").attr("href")).get();
					               
                                    for (Element ref : doc_Article.select("a[class=badge-type]")) {
                                        key_word += ref.text()+" ; ";}
                                    results_citation =doc_Article.select("span[class=citation__top__item article__access]").text() ;
                                    Type =doc_Article.select("span[class=citation__top__item article__tocHeading]").text() ;                                                
                                    journal=doc_Article.select("a[class=article__tocHeading]").text() ;
                                    results+="7: Key word | "+key_word+"\n";
                                    results+="8: Citation access: "+results_citation;
                                    results+="\n9: Journal: "+journal;
                                    results+="\n10: Type: "+Type;
                                    results_References +="\n11: References: \n";
                                    for (Element ref : doc_Article.select("span[class=references__note]")) {
                                        results_References += "               "+i+ " | "  + ref.text()+"\n";}
                                    results+=results_References;					
					//f.Write_in_file( File_References, results_References.split("\n"));	
                                       // f.Write_in_file( filename, results.split("\n"));
                                    
                                    results_References="";
                                    key_word="";
                                    results_citation="";
                                    journal="";
                                    Type="";
                                    
                                   
                              
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
        //    return result_interface;

			  
	
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
}
}