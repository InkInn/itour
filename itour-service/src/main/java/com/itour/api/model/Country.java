package com.itour.api.model;

import java.util.List;
import com.itour.api.model.Province;

public class Country {
	
	private String countryName;
	
	private String countryCode;
	
	private List<Province> proList;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<Province> getProList() {
		return proList;
	}

	public void setProList(List<Province> proList) {
		this.proList = proList;
	}
	

}
