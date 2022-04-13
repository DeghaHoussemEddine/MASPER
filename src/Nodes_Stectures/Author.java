/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes_Stectures;

/**
 *
 * @author Burhan
 */
public class Author {

    private String name;
    private String link;
    
    private int Downloads;
    private int Average_Citaion_Per_Article;
    private int Citations;
    private int publications;
    private String Publication_Years;
    private int Articles_Available_for_Download;
    

    public Author(String authorName, String authorLink) {
        this.name = authorName;
        this.link = authorLink;
    }

    Author() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }

	public int getDownloads() {
		return Downloads;
	}

	public void setDownloads(int downloads) {
		Downloads = downloads;
	}

	public int getAverage_Citaion_Per_Article() {
		return Average_Citaion_Per_Article;
	}

	public void setAverage_Citaion_Per_Article(int average_Citaion_Per_Article) {
		Average_Citaion_Per_Article = average_Citaion_Per_Article;
	}

	public int getCitations() {
		return Citations;
	}

	public void setCitations(int citations) {
		Citations = citations;
	}

	public int getPublications() {
		return publications;
	}

	public void setPublications(int publications) {
		this.publications = publications;
	}

	public String getPublication_Years() {
		return Publication_Years;
	}

	public void setPublication_Years(String publication_Years) {
		Publication_Years = publication_Years;
	}

	public int getArticles_Available_for_Download() {
		return Articles_Available_for_Download;
	}

	public void setArticles_Available_for_Download(int articles_Available_for_Download) {
		Articles_Available_for_Download = articles_Available_for_Download;
	}
    
}
