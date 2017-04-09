package com.itour.api.dao;

import java.util.List;

import com.itour.api.model.Attraction;

public interface AttractionDao {
	
	public List<Attraction> batchSelectAtt(String proCode, String cityCode);
}
