package Crawler_Agents;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ClassHelprs.file;
  
public class Class_SMA_1 {
	static String Search_Query_Model = "https://www.liebertpub.com/action/doSearch?AllField=";
	static String Article_title;
	static String Link_Prefix = "https://www.liebertpub.com";
	static int Page_Number = 1;
	static String Article_numbers = "1";
	static String Link_Postfix = "&startPage=" + Page_Number + "&pageSize=" + Article_numbers;
	static String results;
	static String results_References;
        static String  key_word="";
        static String results_citation="";
        static String journal="";
        static String Type="";
	static int i = 0;
        static String Searching_Sentence="Covid-19";
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
				Document doc = Jsoup.connect(Search_Query_Model + Searching_Sentence + Link_Postfix).get();
				Elements articlesFullDoc;
				articlesFullDoc = doc.select("div[class=article-meta]");
				for (Element article : articlesFullDoc) {
					Article_title = articlesFullDoc.text();
					results += "-----------| " + i + "  |-------------"+"\n";
					results_References+= "-----------| " + i + "  |-------------"+"\n";
                                        try {
                                            results += "1: Date | " +article.select("span[class= meta__epubDate]").text()+"\n";
					} catch (Exception e1) {}
                                        try {
                                            results += "2: TITLE | " + article.select("h5[class=meta__title meta__title__margin]").text()+"\n";
					} catch (Exception e4) {}
                                    	try {
                                            results += "3: Authors | " + article.select("ul").get(0).text()+"\n";
					} catch (Exception e2) {}
                                          try {
                                             results += "4: Abstract | " + article.select("div[class=accordion__content]").text()+"\n";
					} catch (Exception e3) {}
					try {
                                              results += "5: Link | " + Link_Prefix + article.select("a[href]").attr("href")+"\n";
                                              results += "6: Link Access | " + Link_Prefix + article.select("a[class=get-access]").attr("href")+"\n";
					} catch (Exception e) {}	
                                        
                                        Document doc_Article = Jsoup.connect( Link_Prefix + article.select("a[href]").attr("href")).get();
                                        for (Element second : doc_Article.select("a[class=badge-type]")) {
                                            key_word += second.text()+" ; ";}
                                        results_citation =doc_Article.select("span[class=citation__top__item article__access]").text() ;
                                        Type =doc_Article.select("span[class=citation__top__item article__tocHeading]").text() ;                                                
                                        journal=doc_Article.select("a[class=article__tocHeading]").text() ;
                                        results+="7: Key word | "+key_word+"\n";
                                        results+="8: Citation access: "+results_citation;
                                        results+="\n9: Journal: "+journal;
                                        results+="\n10: Type: "+Type;
                                        
                                        
					Thread threadReferences = new Thread(){
                                            public void run(){					   
						for (Element second : doc_Article.select("span[class=references__note]")) {
                                                    results_References += "References "+i+ " | "  + second.text()+"\n";
                                                }		      
                                            }
                                           };
					threadReferences.start();
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

