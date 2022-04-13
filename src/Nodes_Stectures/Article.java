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
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javafx.collections.FXCollections;

public class Article {

	private String iD;
	private String Type;
	private String Title;
	private String Full_Authors;
	private ArrayList<Author> author;
	private String Abstract;
	private ArrayList<Reference> References;
	private String Publiched_date;
	private int Citations;
	private int Downloads;
	private String Link_Access;
	private Journal Journal;
	private ArrayList<String> Keywords;
	
	public Article() {
		// TODO Auto-generated constructor stub
		References = new ArrayList<Reference>();
		author = new ArrayList<Author>();
		 Keywords = new ArrayList<String>();
		
	}
	public Article(String type, String title, ArrayList<Author> author, String abstract1,
			ArrayList<Reference> references, String publiched_date, int citations, int downloads, String link_Access) {
		super();
		Type = type;
		Title = title;
		this.author = author;
		Abstract = abstract1;
		References = references;
		Publiched_date = publiched_date;
		Citations = citations;
		Downloads = downloads;
		Link_Access = link_Access;
	
	}
	
	public String getType() {
		return Type;
	}
	public String getTitle() {
		return Title;
	}
	public ArrayList<Author> getAuthor() {
		return author;
	}
	public String getAbstract() {
		return Abstract;
	}
	public ArrayList<Reference> getReferences() {
		return References;
	}
	public String getPubliched_date() {
		return Publiched_date;
	}
	public int getCitations() {
		return Citations;
	}
	public int getDownloads() {
		return Downloads;
	}
	public String getLink_Access() {
		return Link_Access;
	}
	public void setType(String type) {
		Type = type;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public void setAuthor(ArrayList<Author> author) {
		this.author = author;
	}
	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}
	
	public ArrayList<String> getKeywords() {
		return Keywords;
	}
	public void setKeywords(ArrayList<String> keywords) {
		Keywords = keywords;
	}
	public void setReferences(ArrayList<Reference> references) {
		References = references;
	}
	public void setPubliched_date(String publiched_date) {
		Publiched_date = publiched_date;
	}
	public void setCitations(int citations) {
		Citations = citations;
	}
	public void setDownloads(int downloads) {
		Downloads = downloads;
	}
	public void setLink_Access(String link_Access) {
		Link_Access = link_Access;
	}

	public Journal getJournal() {
		return Journal;
	}

	public void setJournal(Journal journal) {
		Journal = journal;
	}

    public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getFull_Authors() {
		return Full_Authors;
	}
	public void setFull_Authors(String full_Authors) {
		Full_Authors = full_Authors;
	}
}