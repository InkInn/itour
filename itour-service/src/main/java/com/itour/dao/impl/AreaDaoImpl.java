package com.itour.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itour.api.dao.AreaDao;
import com.itour.api.model.City;
import com.itour.api.model.Province;

@Repository("areaDao")
public class AreaDaoImpl implements AreaDao {
	
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplatetea;

	public List<Province> selectPros() {
		String sql = (" SELECT proCode, proName FROM itour_province");
		List<Province> list =  npJdbcTemplatetea.query(sql,
				new BeanPropertyRowMapper<Province>(
						Province.class));
		return list;
	}
	
	public List<Province> selectProsWithCitys() {
//		String sql = (" SELECT proCode, proName FROM itour_province");
//		List<Province> list =  npJdbcTemplatetea.query(sql,
//				new BeanPropertyRowMapper<Province>(
//						Province.class));
//		return list;
		return null;
	}

	
	public Province selectProInfo(String proCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" SELECT proCode, proName FROM itour_province WHERE proCode = :proCode");
		params.put("proCode", proCode);
		Province province =  npJdbcTemplatetea.queryForObject(sql,params,
				new BeanPropertyRowMapper<Province>(
						Province.class));
		return province;
	}


	public List<City> selectCitys(String proCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" SELECT cityCode, cityName FROM itour_city WHERE proCode = :proCode");
		params.put("proCode", proCode);
		List<City> list =  npJdbcTemplatetea.query(sql,params,
				new BeanPropertyRowMapper<City>(
						City.class));
		return list;
	}

	public Map<String, List<City>> batchSelectCitys(List<String> proCodes) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" SELECT cityCode, cityName,proCode FROM itour_city WHERE proCode IN (:proCodes)");
		params.put("proCodes", proCodes);
		List<City> list =  npJdbcTemplatetea.query(sql,params,
				new BeanPropertyRowMapper<City>(
						City.class));
		Map<String, List<City>> map = new HashMap<String,List<City>>();
		
//		System.out.println("******************************");
//		System.out.println(JSON.toJSON(list));
		
		
		for(City city: list){
			List<City> citys = new ArrayList<City>();
			if(map.containsKey(city.getProCode())){
				citys = map.get(city.getProCode());
				citys.add(city);
				map.put(city.getProCode(), citys);
				
			}else{
				citys.add(city);
				map.put(city.getProCode(), citys);
			}
//			System.out.println("******************************");
//			System.out.println(JSON.toJSON(map));
		}
//		System.out.println("******************************");
//		System.out.println(JSON.toJSON(map));
		return map;
	}

}
