package com.itour.api.service;

import java.util.List;

import com.itour.api.model.City;
import com.itour.api.model.Province;

public interface AreaService {
	public List<Province> selectPros();
	
	public Province selectProInfo(String proCode);
	
	public List<City> selcetCitys(String proCode);
}
