package com.itour.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itour.api.dao.TestDao;

@Repository("testDao")
public class TestDaoImpl implements TestDao{

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplatetea;
	public int testInsert() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" SELECT count(id) FROM test");
		Integer count=npJdbcTemplatetea.queryForObject(sql, params, Integer.class);
		return count;
	}

}
