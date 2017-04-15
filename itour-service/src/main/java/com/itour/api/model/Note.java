package com.itour.api.model;

public class Note {
	
	private String title;
	
	private String outline;
	
	private String attCode;
	
	private String proCode;
	
	private String cityCode;
	
	private String authorName;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAttCode() {
		return attCode;
	}

	public void setAttCode(String attCode) {
		this.attCode = attCode;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
}
