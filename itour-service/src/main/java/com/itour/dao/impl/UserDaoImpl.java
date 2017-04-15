package com.itour.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itour.api.dao.UserDao;
import com.itour.api.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplatetea;

	public void insert(User user) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" INSERT INTO itour_user (id,loginName,password) VALUES (:id,:loginName,:password) ");
		params.put("id", user.getId());
		params.put("loginName", user.getLoginName());
		params.put("password", user.getPassword());
		npJdbcTemplatetea.update(sql, params);
	}

	public User findUser(String loginName) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" SELECT loginName,password FROM itour_user WHERE loginName = :loginName ");
		params.put("loginName", loginName);
		List<User> userList = new ArrayList<User>();
		userList =  npJdbcTemplatetea.query(sql,params,
				new BeanPropertyRowMapper<User>(
						User.class));
		if(CollectionUtils.isEmpty(userList)){
			return new User();
		}else{
			return userList.get(0);
		}
	}
}
