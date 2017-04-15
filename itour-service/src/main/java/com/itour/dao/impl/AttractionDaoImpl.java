package com.itour.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itour.api.dao.AttractionDao;
import com.itour.api.model.Attraction;


@Repository("attractionDao")
public class AttractionDaoImpl implements AttractionDao {
	

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplatetea;


	public List<Attraction> batchSelectAtt(String proCode, String cityCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" SELECT name,attCode,attType, introduc FROM itour_attraction WHERE proCode = :proCode AND cityCode = :cityCode");
		params.put("proCode", proCode);
		params.put("cityCode", cityCode);
		List<Attraction> list =  npJdbcTemplatetea.query(sql,params,
				new BeanPropertyRowMapper<Attraction>(
						Attraction.class));
		return list;
	}


	public void addAtt(Attraction attraction) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" INSERT INTO itour_attraction (name,attCode,introduc,attType,proCode,cityCode) VALUES (:name,:attCode,:introduc,:attType,:proCode,:cityCode)");
		
		params.put("name", attraction.getName());
		params.put("attCode", attraction.getAttCode());
		params.put("introduc", attraction.getIntroduc());
		params.put("attType", attraction.getAttType());
		
		params.put("proCode", attraction.getProCode());
		params.put("cityCode", attraction.getCityCode());

		npJdbcTemplatetea.update(sql, params);
	}


	public void updateAtt(Attraction attraction) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" UPDATE  itour_attraction SET name = :name, introduc = :introduc,attType = :attType WHERE attCode = :attCode ");
		
		params.put("name", attraction.getName());
		params.put("introduc", attraction.getIntroduc());
		params.put("attType", attraction.getAttType());
		
		params.put("attCode", attraction.getAttCode());
		npJdbcTemplatetea.update(sql, params);
		
	}


	public void delAtt(String attCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" DELETE FROM itour_attraction  WHERE attCode = :attCode ");
		params.put("attCode",attCode);
		npJdbcTemplatetea.update(sql, params);
		
	}

}
