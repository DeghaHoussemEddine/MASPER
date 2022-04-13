package Nodes_Stectures;

import java.util.ArrayList;

public class Journal {

	private Integer Sourceid;
	private String Title;
	private String Type;
	private String Issn;

	private Float Impact_Factor;
	private Float Acceptance_rate;
	private String TimeTo1stDecision;
	private String Time_to_publication;
	
	private Float SJR;
	private String SJR_Quartile;
	private Integer H_index;
	private Integer Total_Docs;
	private Float CitesByDoc;
	private Float RefByDoc;
	private Float Rank;

	private String Country;
	private String Region;
	private Publicher Publisher;
	private String Coverage;
	private ArrayList<String> Scope;
	private ArrayList<String> Subject_area;
	public Integer getSourceid() {
		return Sourceid;
	}
	public void setSourceid(Integer sourceid) {
		Sourceid = sourceid;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getIssn() {
		return Issn;
	}
	public void setIssn(String issn) {
		Issn = issn;
	}
	public Float getImpact_Factor() {
		return Impact_Factor;
	}
	public void setImpact_Factor(Float impact_Factor) {
		Impact_Factor = impact_Factor;
	}
	public Float getAcceptance_rate() {
		return Acceptance_rate;
	}
	public void setAcceptance_rate(Float acceptance_rate) {
		Acceptance_rate = acceptance_rate;
	}
	public String getTimeTo1stDecision() {
		return TimeTo1stDecision;
	}
	public void setTimeTo1stDecision(String timeTo1stDecision) {
		TimeTo1stDecision = timeTo1stDecision;
	}
	public String getTime_to_publication() {
		return Time_to_publication;
	}
	public void setTime_to_publication(String time_to_publication) {
		Time_to_publication = time_to_publication;
	}
	public Float getSJR() {
		return SJR;
	}
	public void setSJR(Float sJR) {
		SJR = sJR;
	}
	public String getSJR_Quartile() {
		return SJR_Quartile;
	}
	public void setSJR_Quartile(String sJR_Quartile) {
		SJR_Quartile = sJR_Quartile;
	}
	public Integer getH_index() {
		return H_index;
	}
	public void setH_index(Integer h_index) {
		H_index = h_index;
	}
	public Integer getTotal_Docs() {
		return Total_Docs;
	}
	public void setTotal_Docs(Integer total_Docs) {
		Total_Docs = total_Docs;
	}
	public Float getCitesByDoc() {
		return CitesByDoc;
	}
	public void setCitesByDoc(Float citesByDoc) {
		CitesByDoc = citesByDoc;
	}
	public Float getRefByDoc() {
		return RefByDoc;
	}
	public void setRefByDoc(Float refByDoc) {
		RefByDoc = refByDoc;
	}
	public Float getRank() {
		return Rank;
	}
	public void setRank(Float rank) {
		Rank = rank;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public Publicher getPublisher() {
		return Publisher;
	}
	public void setPublisher(Publicher publisher) {
		Publisher = publisher;
	}
	public String getCoverage() {
		return Coverage;
	}
	public void setCoverage(String coverage) {
		Coverage = coverage;
	}
	public ArrayList<String> getScope() {
		return Scope;
	}
	public void setScope(ArrayList<String> scope) {
		Scope = scope;
	}
	public ArrayList<String> getSubject_area() {
		return Subject_area;
	}
	public void setSubject_area(ArrayList<String> subject_area) {
		Subject_area = subject_area;
	}


}
