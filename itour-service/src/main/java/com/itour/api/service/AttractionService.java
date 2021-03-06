package com.itour.api.service;

import java.util.List;

import com.itour.api.model.Attraction;

public interface AttractionService {
	
	public List<Attraction> batchSelectAtt(String proCode, String cityCode);
	
	public void addAtt(Attraction attraction);
	
	public void updateAtt(Attraction attraction);
	
	public  void delAtt(String attCode);

}
