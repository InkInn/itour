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
		String sql = (" SELECT name, introduc FROM itour_attraction WHERE proCode = :proCode AND cityCode = :cityCode");
		params.put("proCode", proCode);
		params.put("cityCode", cityCode);
		List<Attraction> list =  npJdbcTemplatetea.query(sql,params,
				new BeanPropertyRowMapper<Attraction>(
						Attraction.class));
		return list;
	}

}
