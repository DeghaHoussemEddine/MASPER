package Nodes_Stectures;

import java.util.List;

public class Article2 {
    private String articleID;
    private String articleTitle;
    private String articleType;
    private String articleAuthors;
    private String articleAbstract;
    private List<String> articleKeywords;
    private List<String> articleReferences;
    private String articlePublishedDate;
    private String articlePublishedIn;
    private String articleTotalCitations;
    private String articleTotalDownloads;
    private String articleTotalViews;
    private String articleLink;
    private String articleLinkAccess;
    private String articleDownloadLink;

    public Article2(int articleID){
        this.articleID = String.valueOf(articleID);
        this.articleTitle = " ";
        this.articleType = " ";
        this.articleAuthors = " ";
        this.articleAbstract = " ";
        //this.articleKeywords = ;
        //this.articleReferences = ;
        this.articlePublishedDate = " ";
        this.articlePublishedIn = " ";
        this.articleTotalCitations = " ";
        this.articleTotalDownloads = " ";
        this.articleTotalViews = " ";
        this.articleLink = " ";
        this.articleLinkAccess = " ";
        this.articleDownloadLink = " ";
    }

    // Setter methods
    public void setArticleID(String articleID){
        this.articleID = articleID;
    }

    public void setArticleTitle(String articleTitle){
        this.articleTitle = articleTitle;
    }

    public void setArticleType(String articleType){
        if (articleType.isEmpty()){this.articleType = "Unknown";}
        else{this.articleType = articleType;}
    }

    public void setArticleAuthors(String articleAuthors){
        this.articleAuthors = articleAuthors;
    }

    public void setArticleAbstract(String articleAbstract){
        this.articleAbstract = articleAbstract;
    }

    public void setArticleKeywords(List<String> articleKeywords){
        this.articleKeywords = articleKeywords;
    }

    public void setArticleReferences(List<String> articleReferences){
        this.articleReferences = articleReferences;
    }

    public void setArticlePublishedDate(String articlePublishedDate){
        this.articlePublishedDate = articlePublishedDate;
    }

    public void setArticlePublishedIn(String articlePublishedIn){
        this.articlePublishedIn = articlePublishedIn;
    }

    public void setArticleTotalCitations(String articleTotalCitations){
        this.articleTotalCitations = articleTotalCitations;
    }

    public void setArticleTotalDownloads(String articleTotalDownloads){
        this.articleTotalDownloads = articleTotalDownloads;
    }

    public void setArticleTotalViews(String articleTotalViews){
        this.articleTotalViews = articleTotalViews;
    }

    public void setArticleLink(String articleLink){
        this.articleLink = articleLink;
    }

    public void setArticleLinkAccess(String articleLinkAccess){
        this.articleLinkAccess = articleLinkAccess;
    }

    public void setArticleDownloadLink(String articleDownloadLink){
        this.articleDownloadLink = articleDownloadLink;
    }

    // Getter methods
    public String getArticleID(){
        return this.articleID;
    }

    public String getArticleTitle(){
        return this.articleTitle;
    }

    public String getArticleType(){
        if (this.articleType == " "){return "Unknown";}
        else{return this.articleType;}
    }

    public String getArticleAuthors(){
        return this.articleAuthors;
    }

    public String getArticleAbstract(){
        return this.articleAbstract;
    }

    public List<String> getArticleKeywords(){
        return this.articleKeywords;
    }

    public String getArticleKeywordsAsString(){
        return listToString(getArticleKeywords(),", ");
    }

    public List<String> getArticleReferences(){
        return this.articleReferences;
    }

    public String getArticleReferencesAsString(){
        return listToString(getArticleReferences(), "\n");
    }

    public String getArticlePublishedDate(){
        return this.articlePublishedDate;
    }

    public String getArticlePublishedIn(){
        return this.articlePublishedIn;
    }

    public String getArticleTotalCitations(){
        return this.articleTotalCitations;
    }

    public String getArticleTotalDownloads(){
        return this.articleTotalDownloads;
    }

    public String getArticleTotalViews(){
        return this.articleTotalViews;
    }

    public String getArticleLink(){
        return this.articleLink;
    }

    public String getArticleLinkAccess(){
        return this.articleLinkAccess;
    }

    public String getArticleDownloadLink(){
        return this.articleDownloadLink;
    }

    // auther methods
    public String toString(){
        String result = "";
        result+= "ID | " + getArticleID() + "\n";
        result+= "Type | " + getArticleType() + "\n";
        result+= "Date | " + getArticlePublishedDate() + "\n";
        result+= "Title | " + getArticleTitle() + "\n";
        result+= "Authors | " + getArticleAuthors() + "\n";
        result+= "Total Citations | " + getArticleTotalCitations() + "\n";
        //result+= "Total Downloads | " + getArticleTotalDownloads() + "\n";
        result+= "Total Views | " + getArticleTotalViews() + "\n";
        result+= "Link | " + getArticleLink() + "\n";
        result+= "Link Access | " + getArticleLinkAccess() + "\n";
        result+= "Link Download | " + getArticleDownloadLink() + "\n";
        result+= "Publiched in | " + getArticlePublishedIn() + "\n";
        result+= "Abstract | " + getArticleAbstract() + "\n";
        result+= "Keywords | " + getArticleKeywordsAsString() + "\n";
        //result+= "References | \n" + getArticleReferencesAsString() + "\n";
        return result;
    }

    public String referencesToString(){
        String result="================================== Article ID | " +getArticleID()+" =================================="+"\n";
        result+= getArticleReferencesAsString() + "\n";
        return result;
    }

    private String listToString(List<String> list, String separator){
        if(list.isEmpty()){return " ";}
        String stringList = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            stringList+= separator + list.get(i);
        }
        return stringList;
    }

}