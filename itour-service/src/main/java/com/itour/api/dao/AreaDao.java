package com.itour.api.dao;

import java.util.List;
import java.util.Map;

import com.itour.api.model.City;
import com.itour.api.model.Province;

public interface AreaDao {
	public List<Province> selectPros();
	
	public List<Province> selectProsWithCitys();
	
	public Map<String,List<City>> batchSelectCitys(List<String> proCodes);
	
	public Province selectProInfo(String proCode);
	
	public List<City> selectCitys(String proCode);
 }
