package com.itour.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itour.api.model.City;
import com.itour.api.model.Province;
import com.itour.api.service.AreaService;
import com.alibaba.fastjson.JSON;
import com.itour.api.dao.AreaDao;

@Service("areaService")
public class AreaServiceImpl implements AreaService {
	
	@Resource
	private AreaDao areaDao;

	public List<Province> selectPros() {
		List<Province> list = areaDao.selectPros();
		List<String> proCodes = new ArrayList<String>();
		for(Province pro :list){
			proCodes.add(pro.getProCode());
		}
		
		Map<String,List<City>> cityMap = areaDao.batchSelectCitys(proCodes);
		
//		System.out.println("******************************");
//		System.out.println(JSON.toJSON(cityMap));

		for(Province pro : list) {
			pro.setCityList(cityMap.get(pro.getProCode()));
		}
		return list;
	}
	
	public Province selectProInfo(String proCode) {
		Province province = areaDao.selectProInfo(proCode);
		return province;
	}

	public List<City> selcetCitys(String proCode) {
		List<City> list = areaDao.selectCitys(proCode);
		return list;
	}

}
